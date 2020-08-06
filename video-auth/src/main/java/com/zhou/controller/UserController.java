package com.zhou.controller;

import com.zhou.common.response.Result;
import com.zhou.common.response.ResultTool;
import com.zhou.entity.SysUser;
import com.zhou.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author houjun
 * @Date 2020/6/2 22:46
 * @since:
 * @copyright:
 */
@RestController
public class UserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/getUser")
    public Result getUser() {
        List<SysUser> users = sysUserService.queryAllByLimit(1, 100);
        return ResultTool.success(users);
    }
    @GetMapping("/test")
    public Result test() {
        return ResultTool.success("hello world");
    }

}
