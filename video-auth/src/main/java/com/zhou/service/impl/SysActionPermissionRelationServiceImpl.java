package com.zhou.service.impl;

import com.zhou.dao.SysActionPermissionRelationDao;
import com.zhou.entity.SysActionPermissionRelation;
import com.zhou.service.SysActionPermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路径权限关联表(SysActionPermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:25
 */
@Service("sysActionPermissionRelationService")
public class SysActionPermissionRelationServiceImpl implements SysActionPermissionRelationService {

    /**
     * dao引入
     */
    @Autowired
    private SysActionPermissionRelationDao sysActionPermissionRelationDao;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysActionPermissionRelation source) {
        return sysActionPermissionRelationDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysActionPermissionRelationDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysActionPermissionRelation condition) {
        return sysActionPermissionRelationDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysActionPermissionRelation selectOne(int id) {
        return sysActionPermissionRelationDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysActionPermissionRelation selectOne(SysActionPermissionRelation condition) {
        return sysActionPermissionRelationDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysActionPermissionRelation> selectAll() {
        return sysActionPermissionRelationDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysActionPermissionRelation> selectAll(SysActionPermissionRelation condition) {
        return sysActionPermissionRelationDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysActionPermissionRelation source, int id) {
        return sysActionPermissionRelationDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysActionPermissionRelation source, SysActionPermissionRelation condition) {
        return sysActionPermissionRelationDao.updateByCondition(source, condition);
    }
}