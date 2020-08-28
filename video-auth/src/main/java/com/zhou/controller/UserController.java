package com.zhou.controller;

import com.zhou.common.response.Result;
import com.zhou.common.response.ResultCode;
import com.zhou.common.response.ResultTool;
import com.zhou.common.utils.SendSmsUtils;
import com.zhou.dao.SendCodeDao;
import com.zhou.domain.dto.SysUserDTO;
import com.zhou.entity.SendCode;
import com.zhou.entity.SysUser;
import com.zhou.service.SysUserService;
import com.zhou.utils.AccountUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * @Description TODO
 * @Author houjun
 * @Date 2020/6/2 22:46
 * @since:
 * @copyright:
 */
@RestController
@Slf4j
public class UserController {


    /**
     * 数字
     */
    private static final String SYMBOLS = "0123456789";
    private static final Random RANDOM = new SecureRandom();

    @Autowired
    private SysUserService sysUserService;
    @Resource
    private SendCodeDao sendCodeDao;

    @GetMapping("/getUser")
    public Result getUser() {
        log.info("获取当前登录用户");
        SysUser user = sysUserService.getUser();
        if (user != null) {
            return ResultTool.success(user.getUserName());
        } else {
            return ResultTool.success(null);
        }
    }

    /**
     * 校验手机验证码
     */
    @RequestMapping("/checkSmsCode")
    public Result checkSmsCode(String phone, String code) {
        log.info("校验手机验证码");
        return ResultTool.success(sysUserService.checkSmsCode(phone, code));
    }


    /**
     * 校验手机号是否存在
     */
    @RequestMapping("/checkPhone")
    public Result checkPhone(String phone) {
        log.info("校验手机号是否存在");
        return ResultTool.success(sysUserService.checkPhone(phone));
    }


    /**
     * 发送手机验证码
     *
     * @param
     * @return java.lang.String
     */
    @GetMapping("/sendCode")
    public Result sendCode(String mobile) {
        log.info("发送手机验证码");
        //获取随机验证码
        String code = getNonceStr();
        //测试专用
//        String code = "0000";
        //发送验证码
        SendSmsUtils.sendSms(mobile, code);
//        //记录验证码
        addCode(mobile, code);
        return ResultTool.success();
    }

    /**
     * 用户注册
     *
     * @param
     * @return java.lang.String
     */
    @PostMapping("/register")
    public Result register(@Valid SysUserDTO sysUserDTO) {
        log.info("用户注册");
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO, sysUser);
        SysUser existUser = sysUserService.selectByName(sysUser.getAccount());
        SysUser existPhone = sysUserService.selectByPhone(sysUser.getPhone());
        if (existUser != null) {
            return ResultTool.fail(ResultCode.USER_ACCOUNT_USE_EXIST);
        } else if (existPhone != null) {
            return ResultTool.fail(ResultCode.USER_PHONE_USE_EXIST);
        } else if (!sysUserService.checkSmsCode(sysUser.getPhone(), sysUserDTO.getCode())) {
            return ResultTool.fail(ResultCode.USER_PHONE_CODE_ERROR_EXIST);
        } else {
            sysUserService.register(sysUser);
            return ResultTool.success();
        }
    }


    /**
     * 获取长度为 4 的随机数字
     *
     * @return 随机数字
     * @date
     */
    public String getNonceStr() {
        char[] nonceChars = new char[4];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }


    /**
     * 记录验证码
     *
     * @return
     */
    public void addCode(String mobile, String code) {
        SendCode smsCode = new SendCode();
        smsCode.setMobile(mobile);
        smsCode.setCode(code);
        smsCode.setSendTime(new Date());
        smsCode.setType(1);
        smsCode.setStatus(-1);
        sendCodeDao.insert(smsCode);
    }

}
