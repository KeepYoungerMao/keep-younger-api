package com.mao.auth;

import com.alibaba.fastjson.JSON;
import com.mao.entity.ErrResponse;
import com.mao.entity.ResponseData;
import com.mao.entity.ResponseEnum;
import com.mao.entity.auth.SystemRolePermission;
import com.mao.jwt.JwtHandler;
import com.mao.mapper.sys.SystemRolePermissionMapper;
import com.mao.util.SU;
import com.mao.util.SecretEnum;
import com.mao.util.SecretUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author mao by 10:30 2019/8/30
 */
public class SecurityInterceptor implements HandlerInterceptor {

    @Resource
    private SystemRolePermissionMapper systemRolePermissionMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String msg = "";
        //获取token
        String authorization = request.getHeader("Authorization");
        if (SU.isNotEmpty(authorization)){
            long expire = 0;
            String code = "";
            try {
                Claims claims = JwtHandler.parseToken(authorization);
                expire = claims.getExpiration().getTime();
                code = SecretUtil.decrypt(claims.getSubject(),JwtHandler.SECRET_KEY, SecretEnum.AES);
                if (SU.isNotEmpty(code))
                    code = SU.deCode(code);
            } catch (Exception ignored) {}
            if (expire > System.currentTimeMillis()){
                if (SU.isNotEmpty(code)){
                    //url值
                    String url = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
                    //获取判断条件
                    SystemRolePermission permission = systemRolePermissionMapper.getSystemRolePermission(code,url);
                    if (null == permission){
                        flag = false;
                        msg = "no permission to access";
                    } else {
                        if (!permission.isExist()){
                            flag = false;
                            msg = "customer is denied";
                        }
                        if (permission.isLocked()){
                            flag = false;
                            msg = "customer is locked";
                        }
                        if (!permission.isPermission()){
                            flag = false;
                            msg = "customer is denied. no permission";
                        }
                    }
                } else {
                    flag = false;
                    msg = "Authorization is denied";
                }
            } else {
                flag = false;
                msg = "Authorization has expired";
            }
        } else {
            flag = false;
            msg = "Authorization cannot be null";
        }
        if (flag){
            return true;
        } else {
            ResponseData data = new ResponseData<>(ResponseEnum.SECURITY.getCode(),new ErrResponse(msg));
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JSON.toJSONString(data));
            return false;
        }
    }

}