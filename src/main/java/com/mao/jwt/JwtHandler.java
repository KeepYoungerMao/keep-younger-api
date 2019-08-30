package com.mao.jwt;

import com.mao.util.SecretEnum;
import com.mao.util.SecretUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;

/**
 * @author mao by 10:09 2019/8/30
 */
public class JwtHandler {

    public static final String SECRET_KEY = "hello-world";

    /**
     * 生成JWT web token
     * @param code 用户信息类
     * @param expire 过期时间
     * @return token
     */
    public static String createToken(String code, int expire){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,expire);
        return Jwts.builder()
                .setSubject(SecretUtil.encrypt(code,SECRET_KEY, SecretEnum.AES))
                .setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY.getBytes())
                .compact();
    }

    /**
     * 解析token
     * @param token token
     * @return Claims
     */
    public static Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

}