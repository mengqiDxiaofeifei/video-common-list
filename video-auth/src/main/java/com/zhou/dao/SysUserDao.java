package com.zhou.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户表(SysUser)表数据库访问层
 * 该Dao为插件生成
 *
 * @author makejava
 * @since 2020-12-31 10:57:45
 */
public interface SysUserDao extends BaseDao<SysUser> {


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
    SysUser selectRoleResourceByToken(String token);

    /**
     * 分页查询user
     *
     * @param page 分页对象
     * @return List<SysUser> 用户list
     */
    List<SysUser> getUserByPage(Page<SysUser> page, @Param("condition")SysUser sysUser);
}