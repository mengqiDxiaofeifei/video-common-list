package com.zhou.service.impl;

import com.zhou.dao.SysPermissionDao;
import com.zhou.entity.SysPermission;
import com.zhou.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:28
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    /**
     * dao引入
     */
    @Autowired
    private SysPermissionDao sysPermissionDao;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysPermission source) {
        return sysPermissionDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysPermissionDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysPermission condition) {
        return sysPermissionDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysPermission selectOne(int id) {
        return sysPermissionDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysPermission selectOne(SysPermission condition) {
        return sysPermissionDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysPermission> selectAll() {
        return sysPermissionDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysPermission> selectAll(SysPermission condition) {
        return sysPermissionDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysPermission source, int id) {
        return sysPermissionDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysPermission source, SysPermission condition) {
        return sysPermissionDao.updateByCondition(source, condition);
    }
}