package com.zhou.dao;

import com.zhou.entity.SysUserRole;

/**
 * @Description 用户角色关系表数据访问层接口
 * @Author houjun
 * @Date 2020/5/12 23:17
 * @since:
 * @copyright:
 */
public interface SysUserRoleDao {



    /**
     * 新增数据
     *
     * @param
     * @return 影响行数
     */
    int insert(SysUserRole sysUserRole);
}
