package com.zhou.service;

import com.zhou.entity.SysResourcesRoleRelation;

import java.util.List;

/**
 * 角色-权限关联关系表(SysResourcesRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-12-31 10:57:35
 */
public interface SysResourcesRoleRelationService extends Service<SysResourcesRoleRelation> {


    void batchInsert(List<SysResourcesRoleRelation> source);
}