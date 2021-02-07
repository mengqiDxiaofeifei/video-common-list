package com.zhou.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.common.response.Result;
import com.zhou.common.response.ResultTool;
import com.zhou.domain.bo.VideoBO;
import com.zhou.entity.SysUser;
import com.zhou.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
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

    @GetMapping("/info")
    public Result getUserInfo(String token) {
        SysUser user = sysUserService.selectByToken(token);
        if (user != null) {
            return ResultTool.success(user);
        } else {
            return ResultTool.success(null);
        }
    }

    @GetMapping("/user/list")
    public Result getUserInfo(SysUser sysUser) {
        Page<SysUser> page = new Page<>(sysUser.getPage(), sysUser.getLimit());
        Page<SysUser> result = sysUserService.getUserByPage(page,sysUser);
        return ResultTool.success(result);
    }

    @PostMapping("/user/create")
    public Result addUser(@RequestBody SysUser sysUser) {
        sysUserService.addUser(sysUser);
        return ResultTool.success();
    }


    @PutMapping("/user/update")
    public Result updateUser(@RequestBody SysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return ResultTool.success();
    }

    @PutMapping("/user/updateStatus")
    public Result updateStatus(@RequestBody SysUser sysUser) {
        sysUserService.updateStatus(sysUser);
        return ResultTool.success();
    }

    @DeleteMapping("/user/delete")
    public Result deleteUser(SysUser sysUser) {
        sysUserService.deleteSysUser(sysUser);
        return ResultTool.success();
    }






}
