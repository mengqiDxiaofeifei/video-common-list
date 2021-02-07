package com.zhou.service;

import com.zhou.entity.SysRole;
import com.zhou.entity.SysUser;

import java.util.List;

/**
 * 用户角色表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-12-31 10:57:39
 */
public interface SysRoleService extends Service<SysRole> {


    void addRole(SysRole sysRole);

    void updateRole(Integer id,SysRole sysRole);

    Integer insertGeneratedKeys(SysRole source);

    void deleteRole(Integer id);
}