package com.zhou.utils;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AccountUtils {

    /**
     * 获取认证实体
     *
     * @return
     */
    public static User getAuthEntity() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    public static void main(String[] args) {
        String s = IdUtil.randomUUID();
        System.out.println("s = " + s);
    }

}
