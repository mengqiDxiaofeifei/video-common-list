package com.zhou.service;

import java.util.List;

/**
 * 基础Service接口
 *
 * @param <T> 实体对象
 * @author shadow
 * @version 0.0.1
 * @date 2019-01-20
 * @since 0.0.1
 */
public interface Service<T>{
    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    int insert(T source);

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    int deleteOne(Object id);

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    int delete(T condition);

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    T selectOne(int id);

    /**
     * 单个查询
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    T selectOne(T condition);

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    List<T> selectAll();

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    List<T> selectAll(T condition);

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    int update(T source, int id);

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    int update(T source, T condition);
}

