package com.mao.service.auth;

import com.mao.entity.ResponseData;
import com.mao.entity.ResponseEnum;
import com.mao.entity.auth.Token;
import com.mao.entity.auth.UserDo;
import com.mao.entity.auth.UserVo;
import com.mao.jwt.JwtHandler;
import com.mao.mapper.sys.UserMapper;
import com.mao.service.ResponseServiceHandler;
import com.mao.util.SU;
import com.mao.util.SecretEnum;
import com.mao.util.SecretUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 授权
 * @author mao by 11:51 2019/8/23
 */
@Service
public class SecurityServiceHandler implements SecurityService {

    private static final String AUTH_TYPE = "auth";
    private static final String REFRESH_TYPE = "refresh";

    private static final String USER_KEY_FIX = "key";

    private static final String REFRESH_KEY = "refresh-key";

    @Resource
    private ResponseServiceHandler responseServiceHandler;

    @Resource
    private UserMapper userMapper;

    /**
     * 获取token、刷新token
     * @param type 类型：auth、refresh
     * @param app_key 用户接口密钥
     * @param app_secret 用户接口专用名
     * @return token信息
     */
    @Override
    public ResponseData getAuthToken(String type, String app_key, String app_secret, String refresh) {
        switch (type){
            case AUTH_TYPE:
                return getToken(app_key,app_secret);
            case REFRESH_TYPE:
                return refreshToken(refresh);
            default:
                return sendErrorToken("unknown type: "+type);
        }
    }

    /**
     * 获取token，新建token
     * @param app_key 用户接口密钥
     * @param app_secret 用户接口专用名
     * @return ResponseData
     */
    private ResponseData getToken(String app_key, String app_secret){
        if (SU.isEmpty(app_key) || SU.isEmpty(app_secret))
            return sendErrorToken("parameters cannot be null");

        UserDo user = userMapper.getUserByAppSecret(app_secret);
        if (null == user || !app_secret.equals(user.getUser_app_secret()))
            return sendErrorToken("invalid app_secret");

        if (user.isUser_locked())
            return sendErrorToken("customer locked");

        if (!app_key.equals(user.getUser_app_key()))
            return sendErrorToken("invalid app key");

        long expire = getExpire(user);
        long timestamp = System.currentTimeMillis();
        if (expire > timestamp){
            return buildToken(user,timestamp);
        }
        return sendErrorToken("customer has expired");
    }

    /**
     * 刷新token
     * @param refresh 刷新token的refresh值
     * @return ResponseData
     */
    private ResponseData refreshToken(String refresh){
        if (SU.isEmpty(refresh))
            return sendErrorToken("parameter refresh cannot be null");

        refresh = refresh.toUpperCase();
        String decrypt = SecretUtil.decrypt(refresh, REFRESH_KEY, SecretEnum.AES);
        if (SU.isEmpty(decrypt))
            return sendErrorToken("invalid refresh token");

        String code = SU.deCode(decrypt);
        UserDo user = userMapper.getUserByCode(code);
        if (null == user || SU.isEmpty(user.getUser_code()))
            return sendErrorToken("cannot find customer by this refresh token");

        if (user.isUser_locked())
            return sendErrorToken("customer locked");

        long expire = getExpire(user);
        long timestamp = System.currentTimeMillis();
        if (timestamp > expire)
            return sendErrorToken("customer has expired");

        return buildToken(user,timestamp);
    }

    /**
     * 解析app_secret，获取过期时间
     * 注意app_secret转大写
     * @param user 用户信息
     * @return 过期时间
     */
    private long getExpire(UserDo user){
        String decrypt = SecretUtil.decrypt(user.getUser_app_secret().toUpperCase(),
                user.getUser_login()+user.getUser_app_key()+USER_KEY_FIX,SecretEnum.AES);
        return SU.parseLong(decrypt);
    }

    /**
     * 组建成功时的token
     * @param user 用户信息
     * @param timestamp 时间戳
     * @return token信息
     */
    private ResponseData buildToken(UserDo user, long timestamp){
        String token = JwtHandler.createToken(SU.enCode(user.getUser_code()),7200);
        String refresh_token = SecretUtil.encrypt(SU.enCode(user.getUser_code()),
                REFRESH_KEY, SecretEnum.AES);
        if (SU.isNotEmpty(refresh_token)){
            refresh_token = refresh_token.toLowerCase();
            return responseServiceHandler.ok(new Token(token,refresh_token,7200,timestamp));
        }
        return sendErrorToken("not processed in tim, please try again later");
    }

    /**
     * 获取用户信息
     * @param request request
     * @return 用户信息
     */
    @Override
    public ResponseData getUser(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (SU.isEmpty(authorization))
            sendErrorToken("authorization cannot be null");
        long expire = 0;
        String code = "";
        try {
            Claims claims = JwtHandler.parseToken(authorization);
            expire = claims.getExpiration().getTime();
            code = SecretUtil.decrypt(claims.getSubject(),JwtHandler.SECRET_KEY,SecretEnum.AES);
        } catch (Exception ignored) {}
        if (System.currentTimeMillis() > expire)
            return sendErrorToken("authorization has expired");
        if (SU.isEmpty(code))
            return sendErrorToken("invalid authorization");
        code = SU.deCode(code);
        UserVo user = userMapper.getUserInfoByCode(code);
        if (null == user || user.getUser_id() <= 0)
            return sendErrorToken("cannot find customer by this authorization");
        return responseServiceHandler.ok(user);
    }

    /**
     * 错误时的返回处理
     * @param msg 错误信息
     * @return ResponseData
     */
    private ResponseData sendErrorToken(String msg){
        return responseServiceHandler.error(ResponseEnum.BAD_REQUEST,msg);
    }
}