package com.zhou.config.service;

import com.zhou.entity.SysPermission;
import com.zhou.entity.SysUser;
import com.zhou.service.SysPermissionService;
import com.zhou.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author houjun
 * @Date 2020/5/30 0:25
 * @since:
 * @copyright:
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if(StringUtils.isBlank(userName)) {
            throw new RuntimeException("用户不能为空");
        }
        //根据用户名查询用户
        SysUser sysUser = sysUserService.selectByName(userName);
        if(sysUser == null) {
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(sysUser != null){
            //获取改用户所拥有得权限
            List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());
            //申明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(sysUser.getAccount(), sysUser.getPassword(), sysUser.getEnabled(),
                sysUser.getAccountNonExpired(), sysUser.getCredentialsNonExpired(),
                sysUser.getAccountNonLocked(),grantedAuthorities);
    }

}
