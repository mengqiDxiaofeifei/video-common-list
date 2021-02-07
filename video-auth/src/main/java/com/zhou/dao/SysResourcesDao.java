package com.zhou.dao;

import com.zhou.entity.SysResources;
import com.zhou.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SysResources)表数据库访问层
 * 该Dao为插件生成
 *
 *
 * @author makejava
 * @since 2020-12-31 10:57:31
 */
public interface SysResourcesDao extends BaseDao<SysResources> {


    List<SysResources> selectResource();

    List<SysResources> selectChildResources();

    List<SysRole> getRolesResource();

    List<SysResources> selectResourceInIds(@Param("ids") List<Integer> ids);
}