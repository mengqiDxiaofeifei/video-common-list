package com.zhou.controller;

import com.zhou.common.response.Result;
import com.zhou.common.response.ResultTool;
import com.zhou.entity.SysResources;
import com.zhou.entity.SysRole;
import com.zhou.service.SysResourcesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysResources)表控制层
 *
 * @author makejava
 * @since 2021-01-05 10:07:28
 */
@RestController
@RequestMapping("resource")
public class SysResourcesController {
    /**
     * 服务对象
     */
    @Resource
    private SysResourcesService sysResourcesService;

    @GetMapping("/routes")
    public Result getResource() {
        List<SysResources> result = sysResourcesService.getResource();
        return ResultTool.success(result);
    }

}