package com.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Author houjun
 * @Date 2020/6/4 21:55
 * @since:
 * @copyright:
 */
@MapperScan("com.zhou.dao")
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class, args);
    }
}
