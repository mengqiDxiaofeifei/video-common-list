package com.zhou.service.impl;

import com.zhou.common.utils.CheckUtil;
import com.zhou.config.service.PasswordEncoder;
import com.zhou.dao.SendCodeDao;
import com.zhou.dao.SysUserDao;
import com.zhou.dao.SysUserRoleDao;
import com.zhou.entity.SendCode;
import com.zhou.entity.SysUser;
import com.zhou.entity.SysUserRole;
import com.zhou.service.SysUserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description 用户表（SysUser）表服务接口实现
 * @Author houjun
 * @Date 2020/5/12 23:14
 * @since:
 * @copyright:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SendCodeDao sendCodeDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }

    @Override
    public SysUser selectByName(String userName) {
        return this.sysUserDao.selectByName(userName);
    }

    @Override
    public SysUser selectByPhone(String userName) {
        return this.sysUserDao.selectByPhone(userName);
    }


    /**
     * 校验验证码是否正确,如果正确将验证码设为失效
     *
     * @return
     */
    @Override
    public Boolean checkSmsCode(String phone, String code) {
        //设置过期时间
        long outTime = 10 * 60 * 1000;
        SendCode smsCode = sendCodeDao.findByMobile(phone);
        if (CheckUtil.isEmpty(smsCode)) {
            return false;
        }
        long smsCodeTime = smsCode.getSendTime().getTime();
        long nowTime = System.currentTimeMillis();
        if ((nowTime - smsCodeTime) > outTime) {
            return false;
        }
        if (!CheckUtil.isEmpty(smsCode) && smsCode.getCode().equals(code)) {
            return true;
        }
        return false;

    }

    /**
     * 用户注册
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        sysUser.setAccount(sysUser.getUserName());
        sysUser.setLastLoginTime(new Date());
        sysUser.setCreateTime(new Date());
        sysUser.setAccountNonExpired(true);
        sysUser.setAccountNonLocked(true);
        sysUser.setCredentialsNonExpired(true);
        sysUser.setEnabled(true);
        sysUser.setPassword(PasswordEncoder.encoder(sysUser.getPassword()));
        sysUser = insert(sysUser);
        //初始化角色  默认角色为普通角色
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(2);
        sysUserRoleDao.insert(sysUserRole);
    }

    @Override
    public Boolean checkPhone(String phone) {
        SysUser sysUser = sysUserDao.selectByPhone(phone);
        return sysUser == null ? true : false;
    }

    @Override
    public SysUser getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysUserDao.selectByName(user.getUsername());
    }
}
