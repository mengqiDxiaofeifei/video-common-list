package com.zhou.service;

import com.zhou.entity.SysResources;
import com.zhou.entity.SysRole;

import java.util.List;

/**
 * (SysResources)表服务接口
 *
 * @author makejava
 * @since 2020-12-31 10:57:31
 */
public interface SysResourcesService extends Service<SysResources> {

    List<SysResources> getResource();

    List<SysRole> getRolesResource(List<Integer> ids);

    List<SysResources> selectResourceInIds(List<Integer> ids);

    List<SysResources> buildTree(List<SysResources> resources);

    List<SysResources> selectListByPath(String requestUrl);
}