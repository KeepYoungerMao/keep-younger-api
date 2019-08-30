package com.mao.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * token
 * @author mao by 15:35 2019/8/23
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    private String access_token;
    private String refresh_token;
    private int expire;
    private long timestamp;
}