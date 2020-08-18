package com.zhou.entity;

import lombok.Data;

import java.util.Date;

/**
 * SendCode
 *
 * @author zhouhoujun
 * @date 2020/8/14
 */
@Data
public class SendCode {

    /**
     * id
     */
    private Integer id;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 验证码
     */
    private String code;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 类型
     * 1:注册 2:修改密码
     */
    private  Integer type;

    /**
     * 是否验证
     * 0:未验证 1：已验证
     */
    private  Integer status;
}
