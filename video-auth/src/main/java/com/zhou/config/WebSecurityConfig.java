package com.zhou.config;

import com.zhou.config.handler.*;
import com.zhou.config.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * @version 0.1
 * @Description webSecurity核心配置类
 * @Author houjun
 * @Date 2020/4/7 22:10
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**登陆成功处理逻辑**/
    @Resource
    CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    /**登陆失败处理逻辑**/
    @Resource
    CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    /**权限拒绝处理逻辑**/
    @Resource
    CustomizeAccessDeniedHandler accessDeniedHandler;

    /**匿名用户访问无权限资源时得异常**/
    @Resource
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    /**会话失效（账号被挤下线）处理逻辑**/
    @Resource
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    /**登出成功处理逻辑**/
    @Resource
    CustomizeLogoutSuccessHandler logoutSuccessHandler;

    /**访问决策管理器**/
    @Resource
    CustomizeAccessDecisionManager accessDecisionManager;

    /**实现权限拦截**/
    @Resource
    CustomizeFilterInvocationSecurityMetadataSource securityMetadataSource;

    @Resource
    private CustomizeAbstractSecurityInterceptor securityInterceptor;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests().
                //antMatchers("/getUser").hasAuthority("query_user").
//                antMatchers("/**")
                        withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                        return o;
                    }
                }).
                //登出
                and().logout().
                permitAll().//允许所有用户
                //登出成功处理逻辑
                logoutSuccessHandler(logoutSuccessHandler).
                //登出之后删除cookie
                deleteCookies("JSESSIONID").
                //登入
                and().formLogin().
                //允许所有用户
                permitAll().
                //登录成功处理逻辑
                successHandler(authenticationSuccessHandler).
                //登录失败处理逻辑
                failureHandler(authenticationFailureHandler).
                //异常处理(权限拒绝、登录失效等)
                        and().exceptionHandling().
                //权限拒绝处理逻辑
                accessDeniedHandler(accessDeniedHandler).
                //匿名用户访问无权限资源时的异常处理
                authenticationEntryPoint(authenticationEntryPoint).
                //会话管理
                        and().sessionManagement().
                //同一账号同时登录最大用户数
                maximumSessions(1).
                //会话失效(账号被挤下线)处理逻辑
                expiredSessionStrategy(sessionInformationExpiredStrategy);
//        http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class);
    }

}
