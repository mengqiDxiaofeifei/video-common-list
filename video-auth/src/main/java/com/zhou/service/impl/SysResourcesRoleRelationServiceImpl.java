package com.zhou.service.impl;

import com.zhou.dao.SysResourcesRoleRelationDao;
import com.zhou.entity.SysResourcesRoleRelation;
import com.zhou.service.SysResourcesRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色-权限关联关系表(SysResourcesRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:36
 */
@Service("sysResourcesRoleRelationService")
public class SysResourcesRoleRelationServiceImpl implements SysResourcesRoleRelationService {

    /**
     * dao引入
     */
    @Autowired
    private SysResourcesRoleRelationDao sysResourcesRoleRelationDao;




    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysResourcesRoleRelation source) {

        return sysResourcesRoleRelationDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysResourcesRoleRelationDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysResourcesRoleRelation condition) {
        return sysResourcesRoleRelationDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysResourcesRoleRelation selectOne(int id) {
        return sysResourcesRoleRelationDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysResourcesRoleRelation selectOne(SysResourcesRoleRelation condition) {
        return sysResourcesRoleRelationDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysResourcesRoleRelation> selectAll() {
        return sysResourcesRoleRelationDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysResourcesRoleRelation> selectAll(SysResourcesRoleRelation condition) {
        return sysResourcesRoleRelationDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysResourcesRoleRelation source, int id) {
        return sysResourcesRoleRelationDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysResourcesRoleRelation source, SysResourcesRoleRelation condition) {
        return sysResourcesRoleRelationDao.updateByCondition(source, condition);
    }

    @Override
    public void batchInsert(List<SysResourcesRoleRelation> source) {
        source.forEach(s -> sysResourcesRoleRelationDao.insert(s));
    }
}