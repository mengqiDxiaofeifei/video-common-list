package com.zhou.dao;

import com.zhou.constant.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DAO接口
 *
 * @modify shadow 2020-08-06 16:16:19 使用Mycat实现读写分离。去除{@link cn.sh.ideal.core.annotation.TargetDataSource}
 * @param <T> 实体对象
 * @author shadow
 * @version 1.0
 * @date 2019-01-20
 * @since 1.0
 */
@SuppressWarnings("ALL")
public interface BaseDao<T> {

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
     * 条件删除
     *
     * @param condition 删除条件
     * @return int
     */
    int deleteByCondition(T condition);

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    T selectOne(Object id);

    /**
     * 单个查询
     *
     * @param condition 查询条件
     * @return 对象
     */
    T selectOneByCondition(T condition);

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
    List<T> selectAllByCondition(T condition);

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    int updateById(@Param(Constants.SOURCE_SIGN) T source, @Param("id") Object id);

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    int updateByCondition(@Param(Constants.SOURCE_SIGN) T source, @Param(Constants.CONDITION_SIGN) T condition);


}

