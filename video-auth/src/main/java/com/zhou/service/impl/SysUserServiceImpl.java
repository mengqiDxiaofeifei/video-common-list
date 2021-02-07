package com.zhou.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.dao.SysResourcesDao;
import com.zhou.dao.SysRoleDao;
import com.zhou.dao.SysUserDao;
import com.zhou.entity.SysResources;
import com.zhou.entity.SysRole;
import com.zhou.entity.SysUser;
import com.zhou.service.SysResourcesService;
import com.zhou.service.SysRoleService;
import com.zhou.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 10:57:46
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    /**
     * dao引入
     */
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysResourcesService  sysResourcesService;

    @Autowired
    private SysRoleDao sysRoleDao;
    /**
     * 新增数据
     *
     * @param source 数据对象
     * @return int
     */
    @Override
    public int insert(SysUser source) {

        return sysUserDao.insert(source);
    }

    /**
     * 单个删除
     *
     * @param id id
     * @return int
     */
    @Override
    public int deleteOne(Object id) {
        return sysUserDao.deleteOne(id);
    }

    /**
     * 删除
     *
     * @param condition 删除条件
     * @return int
     */
    @Override
    public int delete(SysUser condition) {
        return sysUserDao.deleteByCondition(condition);
    }

    /**
     * 单个查询
     *
     * @param id id
     * @return 对象
     */
    @Override
    public SysUser selectOne(int id) {
        return sysUserDao.selectOne(id);
    }

    /**
     * 单个查询
     * 需要注意为伪单个查询，通过下标获取。注意使用场景
     *
     * @param condition 查询条件
     * @return 单个对象
     */
    @Override
    public SysUser selectOne(SysUser condition) {
        return sysUserDao.selectAllByCondition(condition).get(0);
    }

    /**
     * 查询全部-无条件
     *
     * @return 所有数据
     */
    @Override
    public List<SysUser> selectAll() {
        return sysUserDao.selectAll();
    }

    /**
     * 查询全局-有条件
     *
     * @param condition 查询条件
     * @return 所有数据
     */
    @Override
    public List<SysUser> selectAll(SysUser condition) {
        return sysUserDao.selectAllByCondition(condition);
    }

    /**
     * 更新
     *
     * @param source 数据对象
     * @param id     ID
     * @return int
     */
    @Override
    public int update(SysUser source, int id) {
        return sysUserDao.updateById(source, id);
    }

    /**
     * 条件更新
     *
     * @param source    数据对象
     * @param condition 更新条件
     * @return int
     */
    @Override
    public int update(SysUser source, SysUser condition) {
        return sysUserDao.updateByCondition(source, condition);
    }


    /**
     * 根据用户名查询User
     *
     * @param username 用户名
     * @return SysUser
     */
    @Override
    public SysUser selectByName(String username) {
        return sysUserDao.selectByName(username);
    }


    /**
     * 根据token查询User
     *
     * @param token 令牌
     * @return SysUser
     */
    @Override
    public SysUser selectByToken(String token) {
        SysUser user = sysUserDao.selectRoleResourceByToken(token);
        List<Integer> rids = user.getRoles().stream().map(SysRole::getId).collect(Collectors.toList());
        List<SysRole> roles = sysRoleDao.getResourceRole(rids);
        List<SysResources> sysResources = new ArrayList<>();
        for (SysRole role : roles) {
            List<Integer> ids = role.getRoutes().stream().map(SysResources::getId).collect(Collectors.toList());
            if(CollectionUtil.isNotEmpty(ids)){
                List<SysResources> resources =  sysResourcesService.selectResourceInIds(ids);
                sysResources.addAll(resources);
            }
        }
        sysResources = sysResources.stream().distinct().collect(Collectors.toList());
        List<SysResources> sysResources1 = sysResourcesService.buildTree(sysResources);
        user.setRoutes(sysResources1);
        return user;
    }


    /**
     * 分页查询user
     *
     * @param page    分页对象
     * @param sysUser 用户
     * @return Page<SysUser> 用户list
     */
    @Override
    public Page<SysUser> getUserByPage(Page<SysUser> page, SysUser sysUser) {
        page.setRecords(sysUserDao.getUserByPage(page, sysUser));
        return page;
    }

    /**
     * 更新user
     *
     * @param sysUser 用户
     */
    @Override
    public void updateUser(SysUser sysUser) {
        this.update(sysUser, sysUser.getId());
    }

    /**
     * 添加user
     *
     * @param sysUser 用户
     */
    @Override
    public void addUser(SysUser sysUser) {
        this.insert(SysUser.initSysUser(sysUser));
    }

    /**
     * 删除user
     *
     * @param sysUser 用户
     */
    @Override
    public void deleteSysUser(SysUser sysUser) {
        this.deleteOne(sysUser.getId());
    }

    /**
     * 更新状态user
     *
     * @param sysUser 用户
     */
    @Override
    public void updateStatus(SysUser sysUser) {
        this.update(sysUser,sysUser.getId());
    }
}