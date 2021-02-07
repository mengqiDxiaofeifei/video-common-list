package com.zhou.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.entity.SysUser;

/**
 * 系统用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-12-31 10:57:46
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 根据用户名查询User
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser selectByName(String username);

    /**
     * 根据token查询User
     *
     * @param token 令牌
     * @return SysUser
     */
    SysUser selectByToken(String token);

    /**
     * 分页查询user
     *
     * @param page 分页对象
     * @param sysUser 用户
     * @return Page<SysUser> 用户list
     */
    Page<SysUser> getUserByPage(Page<SysUser> page, SysUser sysUser);

    /**
     * 更新user
     *
     * @param sysUser 用户
     */
    void updateUser(SysUser sysUser);

    /**
     * 添加user
     *
     * @param sysUser 用户
     */
    void addUser(SysUser sysUser);

    /**
     * 删除user
     *
     * @param sysUser 用户
     */
    void deleteSysUser(SysUser sysUser);

    /**
     * 更新状态user
     *
     * @param sysUser 用户
     */
    void updateStatus(SysUser sysUser);
}