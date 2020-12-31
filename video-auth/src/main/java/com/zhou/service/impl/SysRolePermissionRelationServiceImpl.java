package com.zhou.service.impl;

import com.zhou.dao.SysRolePermissionRelationDao;
import com.zhou.entity.SysRolePermissionRelation;
import com.zhou.service.SysRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:43
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl implements SysRolePermissionRelationService {

    /**
     * dao引入
     */
    @Autowired
    private SysRolePermissionRelationDao sysRolePermissionRelationDao;




    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysRolePermissionRelation source) {

        return sysRolePermissionRelationDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysRolePermissionRelationDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysRolePermissionRelation condition) {
        return sysRolePermissionRelationDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysRolePermissionRelation selectOne(int id) {
        return sysRolePermissionRelationDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysRolePermissionRelation selectOne(SysRolePermissionRelation condition) {
        return sysRolePermissionRelationDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysRolePermissionRelation> selectAll() {
        return sysRolePermissionRelationDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysRolePermissionRelation> selectAll(SysRolePermissionRelation condition) {
        return sysRolePermissionRelationDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysRolePermissionRelation source, int id) {
        return sysRolePermissionRelationDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysRolePermissionRelation source, SysRolePermissionRelation condition) {
        return sysRolePermissionRelationDao.updateByCondition(source, condition);
    }
}