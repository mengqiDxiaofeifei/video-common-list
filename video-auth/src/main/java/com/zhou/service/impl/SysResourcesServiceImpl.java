package com.zhou.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhou.dao.SysResourcesDao;
import com.zhou.dao.SysRoleDao;
import com.zhou.entity.SysResources;
import com.zhou.entity.SysRole;
import com.zhou.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (SysResources)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:32
 */
@Service("sysResourcesService")
public class SysResourcesServiceImpl implements SysResourcesService {


    /**
     * dao引入
     */
    @Autowired
    private SysResourcesDao sysResourcesDao;
    @Autowired
    private SysRoleDao sysRoleDao;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysResources source) {

        return sysResourcesDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysResourcesDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysResources condition) {
        return sysResourcesDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysResources selectOne(int id) {
        return sysResourcesDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysResources selectOne(SysResources condition) {
        return sysResourcesDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysResources> selectAll() {
        return sysResourcesDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysResources> selectAll(SysResources condition) {
        return sysResourcesDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysResources source, int id) {
        return sysResourcesDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysResources source, SysResources condition) {
        return sysResourcesDao.updateByCondition(source, condition);
    }

    @Override
    public List<SysResources> getResource() {
        return sysResourcesDao.selectResource();
    }

    @Override
    public List<SysRole> getRolesResource(List<Integer> rids) {
        List<SysRole> roles = sysRoleDao.getResourceRole(rids);
        for (SysRole role : roles) {
            List<Integer> ids = role.getRoutes().stream().map(SysResources::getId).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(ids)) {
                List<SysResources> resources = sysResourcesDao.selectResourceInIds(ids);
                role.setRoutes(buildTree(resources));
            }
        }
        return roles;
    }

    @Override
    public List<SysResources> selectResourceInIds(List<Integer> ids) {
        return sysResourcesDao.selectResourceInIds(ids);
    }

    @Override
    public List<SysResources> buildTree(List<SysResources> resources) {
        List<SysResources> result = new ArrayList<>();
        for (SysResources resource : resources) {
            if (0 == resource.getPid()) {
                result.add(resource);
            }
            for (SysResources res : resources) {
                if (res.getPid().equals(resource.getId())) {
                    if (resource.getChildren() == null) {
                        List<SysResources> child = new ArrayList<>();
                        child.add(res);
                        resource.setChildren(child);
                    } else {
                        resource.getChildren().add(res);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<SysResources> selectListByPath(String requestUrl) {
        SysResources condition = new SysResources();
        condition.setUrl(requestUrl);
        return sysResourcesDao.selectAllByCondition(condition);
    }

}