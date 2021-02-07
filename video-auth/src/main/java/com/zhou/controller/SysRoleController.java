package com.zhou.controller;

import com.zhou.common.response.Result;
import com.zhou.common.response.ResultTool;
import com.zhou.entity.SysRole;
import com.zhou.service.SysResourcesService;
import com.zhou.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色表(SysRole)表控制层
 *
 * @author makejava
 * @since 2021-01-04 17:02:38
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysResourcesService sysResourcesService;

    @GetMapping("/roles")
    public Result getRoles() {
        List<SysRole> result = sysResourcesService.getRolesResource(null);
        return ResultTool.success(result);
    }

    @PostMapping("/create")
    public Result addRole(@RequestBody SysRole sysRole) {
        sysRoleService.addRole(sysRole);
        return ResultTool.success();
    }


    @PutMapping("/{id}")
    public Result updateRole(@PathVariable("id")Integer id,@RequestBody SysRole sysRole) {
        sysRoleService.updateRole(id,sysRole);
        return ResultTool.success();
    }


    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable("id")Integer id) {
        sysRoleService.deleteRole(id);
        return ResultTool.success();
    }
}