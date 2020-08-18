package com.zhou.config.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密类
 *
 * @author zhouhoujun
 * @date 2020/8/17
 */
public class PasswordEncoder {


    /**
     * 功能描述: 密码加密
     *
     * @Param: [password]
     * @Return: java.lang.String
     * @Author: houjun
     * @Date: 2020/8/17 9:38
     */
    public static String encoder(String password) {
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        return bpe.encode(password);
    }

}
