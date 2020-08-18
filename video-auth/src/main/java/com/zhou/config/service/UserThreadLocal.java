package com.zhou.config.service;

import com.zhou.entity.SysUser;


/**
 * 获取当前用户工具类
 *
 * @Author: houjun
 * @Date: 2020/8/17 13:58
 */
public class UserThreadLocal {

    private static ThreadLocal<SysUser> userThread = new ThreadLocal<>();

    public static void set(SysUser user) {

        userThread.set(user);
    }

    public static SysUser get() {

        return userThread.get();
    }

    //防止内存泄漏
    public static void remove() {

        userThread.remove();
    }

}