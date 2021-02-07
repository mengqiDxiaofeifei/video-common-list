package com.zhou.config.handler;

import com.zhou.entity.SysResources;
import com.zhou.service.SysResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 *@Description 实现权限拦截
 *@Author houjun
 *@Date 2020/5/19 23:42
 *@since:
 *@copyright:
 */
@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    SysResourcesService sysResourcesService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        //查询具体某个接口的权限
        List<SysResources> sysResources = sysResourcesService.selectListByPath(requestUrl);
        if(sysResources == null || sysResources.size() == 0){
            //请求路径没有配置权限，表明该请求接口可以任意访问
            return null;
        }
        String[] attributes = new String[sysResources.size()];
        for(int i = 0;i<sysResources.size();i++){
            attributes[i] = sysResources.get(i).getCode();
        }
        return SecurityConfig.createList(attributes);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
