package com.zhou.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * SysUserDTO
 *
 * @author zhouhoujun
 * @date 2020/8/28
 */
@Data
public class SysUserDTO {


    /**
     * 用户名
     */
    @NotNull
    @Length(message = "用户名必须6-12位",min = 6,max = 12)
    private String userName;
    /**
     * 用户密码
     */
    @NotNull
    @Length(message = "用户名必须6-12位",min = 6,max = 12)
    @Pattern(regexp = "^[\u4E00-\u9FA5A-Za-z0-9_]+$", message = "最少6位到12位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
    private String password;
    /**
     * 手机号
     */
    @NotNull
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "手机号格式不正确")
    private String phone;
    /**
     * 短信验证码
     */
    @NotNull
    @Pattern(regexp = "^[0-9]{4}$", message = "短信验证码格式不正确")
    private String code;
}
