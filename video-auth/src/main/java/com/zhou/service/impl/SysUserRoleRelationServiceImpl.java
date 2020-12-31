package com.zhou.service.impl;
import com.zhou.dao.SysUserRoleRelationDao;
import com.zhou.entity.SysUserRoleRelation;
import com.zhou.service.SysUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:50
 */
@Service("sysUserRoleRelationService")
public class SysUserRoleRelationServiceImpl implements SysUserRoleRelationService {

    /**
     * dao引入
     */
    @Autowired
    private SysUserRoleRelationDao sysUserRoleRelationDao;

    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysUserRoleRelation source) {
        return sysUserRoleRelationDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysUserRoleRelationDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysUserRoleRelation condition) {
        return sysUserRoleRelationDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysUserRoleRelation selectOne(int id) {
        return sysUserRoleRelationDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysUserRoleRelation selectOne(SysUserRoleRelation condition) {
        return sysUserRoleRelationDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysUserRoleRelation> selectAll() {
        return sysUserRoleRelationDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysUserRoleRelation> selectAll(SysUserRoleRelation condition) {
        return sysUserRoleRelationDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysUserRoleRelation source, int id) {
        return sysUserRoleRelationDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysUserRoleRelation source, SysUserRoleRelation condition) {
        return sysUserRoleRelationDao.updateByCondition(source, condition);
    }
}