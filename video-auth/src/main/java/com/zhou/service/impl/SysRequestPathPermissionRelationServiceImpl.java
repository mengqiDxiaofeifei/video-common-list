package com.zhou.service.impl;

import com.zhou.dao.SysRequestPathPermissionRelationDao;
import com.zhou.entity.SysRequestPathPermissionRelation;
import com.zhou.service.SysRequestPathPermissionRelationService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 *@Description 路径权限关联表(SysRequestPathPermissionRelation)表服务实现类
 *@Author houjun
 *@Date 2020/5/16 17:28
 *@since:
 *@copyright:
 */
@Service("sysRequestPathPermissionRelationService")
public class SysRequestPathPermissionRelationServiceImpl implements SysRequestPathPermissionRelationService {
    @Resource
    private SysRequestPathPermissionRelationDao sysRequestPathPermissionRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation queryById(Integer id) {
        return this.sysRequestPathPermissionRelationDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRequestPathPermissionRelation> queryAllByLimit(int offset, int limit) {
        return this.sysRequestPathPermissionRelationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRequestPathPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation insert(SysRequestPathPermissionRelation sysRequestPathPermissionRelation) {
        this.sysRequestPathPermissionRelationDao.insert(sysRequestPathPermissionRelation);
        return sysRequestPathPermissionRelation;
    }

    /**
     * 修改数据
     *
     * @param sysRequestPathPermissionRelation 实例对象
     * @return 实例对象
     */
    @Override
    public SysRequestPathPermissionRelation update(SysRequestPathPermissionRelation sysRequestPathPermissionRelation) {
        this.sysRequestPathPermissionRelationDao.update(sysRequestPathPermissionRelation);
        return this.queryById(sysRequestPathPermissionRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysRequestPathPermissionRelationDao.deleteById() > 0;
    }
}