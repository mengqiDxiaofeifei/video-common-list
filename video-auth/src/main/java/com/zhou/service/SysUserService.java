package com.zhou.service;

import com.zhou.entity.SysUser;
import java.util.List;

/**
 * @version 0.1
 * @Description 用户表（SysUser）表服务接口
 * @Author houjun
 * @Date 2020/4/7 22:35
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    SysUser selectByName(String userName);
    /**
     * 根据手机号名查询用户
     *
     * @param userName
     * @return
     */
    SysUser selectByPhone(String userName);

    /**
     * 校验短信验证码
     *
     * @param
     * @return
     */
    Boolean checkSmsCode(String phone, String code);


    /**
     * 用户注册
     *
     * @param
     * @return
     */
    void register(SysUser sysUser);

    /**
     * 判断手机号是否存在
     *
     * @param
     * @return
     */
    Boolean checkPhone(String phone);
}
