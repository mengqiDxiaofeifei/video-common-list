package com.zhou.entity;

import com.zhou.config.service.PasswordEncoder;
import com.zhou.domain.vo.ReqPage;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:44
 */
@Data
public class SysUser extends ReqPage implements Serializable {
    private static final long serialVersionUID = 334259366590364040L;

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
     * 上一次登陆时间
     */
    private Date lastLoginTime;
    /**
     * 账号是否可用。默认1（可用）
     */
    private Integer enabled;
    /**
     * 是否过期。默认1（没有过期）
     */
    private Integer accountNonExpired;
    /**
     * 账号是否锁定。默认1（没有锁定）
     */
    private Integer accountNonLocked;
    /**
     * 证书（密码）是否过期。默认1（没有过期）
     */
    private Integer credentialsNonExpired;
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
    /**
     * 手机号
     */
    private String phone;
    /**
     * 令牌
     */
    private String token;

    /**
     * 角色
     */
    private List<SysRole> roles;
    /**
     * 资源
     */
    private List<SysResources> routes;

    /**
     * 日志转换
     *
     * @param sysUser 用户
     * @return {@link SysUser}
     */
    public static SysUser initSysUser(SysUser sysUser) {
        sysUser.setPassword(PasswordEncoder.encoder(sysUser.getPassword()));
        sysUser.setLastLoginTime(new Date());
        sysUser.setCreateTime(new Date());
        sysUser.setCreateTime(new Date());
        sysUser.setEnabled(1);
        sysUser.setAccountNonExpired(1);
        sysUser.setAccountNonLocked(1);
        sysUser.setCredentialsNonExpired(1);
        return sysUser;
    }
}