package com.zhou.dao;

import com.zhou.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色表(SysRole)表数据库访问层
 * 该Dao为插件生成
 *
 * @author makejava
 * @since 2020-12-31 10:57:38
 */
public interface SysRoleDao extends BaseDao<SysRole> {

    Integer insertGeneratedKeys(SysRole sysRole);

    List<SysRole> getResourceRole(@Param("ids") List<Integer> ids);

}