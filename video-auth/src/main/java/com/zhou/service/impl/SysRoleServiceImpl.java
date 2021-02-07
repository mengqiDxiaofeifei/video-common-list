package com.zhou.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhou.dao.SysRoleDao;
import com.zhou.entity.SysResources;
import com.zhou.entity.SysResourcesRoleRelation;
import com.zhou.entity.SysRole;
import com.zhou.entity.SysUser;
import com.zhou.service.SysResourcesRoleRelationService;
import com.zhou.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:39
 */
@Service("sysRoleService")

public class SysRoleServiceImpl implements SysRoleService {

    /**
     * dao引入
     */
    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysResourcesRoleRelationService sysResourcesRoleRelationService;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysRole source) {
        return sysRoleDao.insert(source);
    }


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public Integer insertGeneratedKeys(SysRole source) {
        return sysRoleDao.insertGeneratedKeys(source);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRole(Integer id) {
        this.deleteOne(id);
        SysResourcesRoleRelation srr = new SysResourcesRoleRelation();
        srr.setRoleId(id);
        sysResourcesRoleRelationService.delete(srr);
    }


    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysRoleDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysRole condition) {
        return sysRoleDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysRole selectOne(int id) {
        return sysRoleDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysRole selectOne(SysRole condition) {
        return sysRoleDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysRole> selectAll() {
        return sysRoleDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysRole> selectAll(SysRole condition) {
        return sysRoleDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysRole source, int id) {
        return sysRoleDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysRole source, SysRole condition) {
        return sysRoleDao.updateByCondition(source, condition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(SysRole sysRole) {
        this.insertGeneratedKeys(sysRole);
        List<SysResourcesRoleRelation> list = new ArrayList<>();
        List<SysResources> routes = sysRole.getRoutes();
        getResource(routes, list, sysRole.getId());
        sysResourcesRoleRelationService.batchInsert(list);
    }

    public void getResource(List<SysResources> routes,
                            List<SysResourcesRoleRelation> list, Integer roleId) {
        routes.forEach(route -> {
            SysResourcesRoleRelation relation = new SysResourcesRoleRelation();
            relation.setRoleId(roleId);
            relation.setResourcesId(route.getId());
            list.add(relation);
            if (CollectionUtil.isNotEmpty(route.getChildren())) {
                getResource(route.getChildren(), list, roleId);
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(Integer id,SysRole sysRole) {
        this.update(sysRole, id);
        SysResourcesRoleRelation srr = new SysResourcesRoleRelation();
        srr.setRoleId(id);
        sysResourcesRoleRelationService.delete(srr);
        List<SysResourcesRoleRelation> list = new ArrayList<>();
        List<SysResources> routes = sysRole.getRoutes();
        getResource(routes, list, sysRole.getId());
        sysResourcesRoleRelationService.batchInsert(list);
    }
}