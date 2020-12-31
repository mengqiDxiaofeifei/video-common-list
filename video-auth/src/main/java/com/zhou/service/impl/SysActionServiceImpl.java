package com.zhou.service.impl;

import com.zhou.dao.SysActionDao;
import com.zhou.entity.SysAction;
import com.zhou.service.SysActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysAction)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:21
 */
@Service("sysActionService")
public class SysActionServiceImpl implements SysActionService {

    /**
     * dao引入
     */
    @Autowired
    private SysActionDao sysActionDao;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysAction source) {
        return sysActionDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysActionDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysAction condition) {
        return sysActionDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysAction selectOne(int id) {
        return sysActionDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysAction selectOne(SysAction condition) {
        return sysActionDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysAction> selectAll() {
        return sysActionDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysAction> selectAll(SysAction condition) {
        return sysActionDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysAction source, int id) {
        return sysActionDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysAction source, SysAction condition) {
        return sysActionDao.updateByCondition(source, condition);
    }
}