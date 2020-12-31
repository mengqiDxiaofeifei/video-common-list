package com.zhou.service.impl;

import com.zhou.dao.SysResourcesDao;
import com.zhou.entity.SysResources;
import com.zhou.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}