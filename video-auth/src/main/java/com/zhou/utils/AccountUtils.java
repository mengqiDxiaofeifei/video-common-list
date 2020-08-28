package com.zhou.utils;

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


}
