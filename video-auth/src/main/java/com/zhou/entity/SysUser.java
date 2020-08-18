package com.zhou.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 0.1
 * @Description 用户表（sys_user）实体类
 * @Author houjun
 * @Date 2020/4/7 22:40
 */
@Data
public class SysUser implements Serializable {

    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 手机号
     */
     private String phone;
    /**
     * 上一次登陆时间
     */
    private Date lastLoginTime;
    /**
     * 账号是否可用。默认1（可用）
     */
    private Boolean enabled;
    /**
     * 是否过期。默认1（没有过期）
     */
    private Boolean accountNonExpired;
    /**
     * 账号是否锁定。默认1（没有锁定）
     */
    private Boolean accountNonLocked;
    /**
     * 证书（密码）是否过期。默认1（没有过期）
     */
    private Boolean credentialsNonExpired;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private Integer createUser;
    /**
     * 修改人
     */
    private Integer updateUser;

}
