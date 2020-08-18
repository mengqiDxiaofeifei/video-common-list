package com.zhou.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

public class GlobalCorsConfig {

    /**
     * 允许跨域调用的过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        //允许所有域名进行跨域调用
        CorsConfiguration config = new CorsConfiguration();
        //允许跨越发送cookie
        config.addAllowedOrigin("*");
        //放行全部原始头信息
        config.setAllowCredentials(true);
        //允许所有请求方法跨域调用
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

