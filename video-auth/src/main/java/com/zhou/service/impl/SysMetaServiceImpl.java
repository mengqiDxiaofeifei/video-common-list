package com.zhou.service.impl;

import com.zhou.dao.SysMetaDao;
import com.zhou.entity.SysMeta;
import com.zhou.service.SysMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysMeta)表服务实现类
 *
 * @author makejava
 * @since 2021-01-05 10:30:32
 */
@Service("sysMetaService")
public class SysMetaServiceImpl implements SysMetaService {

    /**
     * dao引入
     */
    @Autowired
    private SysMetaDao sysMetaDao;


    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysMeta source) {
        return sysMetaDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysMetaDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysMeta condition) {
        return sysMetaDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysMeta selectOne(int id) {
        return sysMetaDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysMeta selectOne(SysMeta condition) {
        return sysMetaDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysMeta> selectAll() {
        return sysMetaDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysMeta> selectAll(SysMeta condition) {
        return sysMetaDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysMeta source, int id) {
        return sysMetaDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysMeta source, SysMeta condition) {
        return sysMetaDao.updateByCondition(source, condition);
    }
}