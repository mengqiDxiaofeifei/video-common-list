package com.zhou.controller.video;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.common.response.Result;
import com.zhou.common.response.ResultTool;
import com.zhou.domain.bo.VideoBO;
import com.zhou.domain.dto.VideoDTO;
import com.zhou.domain.vo.VideoVO;
import com.zhou.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * VideoContorller
 *
 * @author zhouhoujun
 * @date 2020/8/20
 */
@RestController
@RequestMapping("/vi/video")
@Slf4j
public class VideoContorller {


    @Autowired
    private VideoService videoService;


    @GetMapping("")
    public Result getVideoList(@Valid VideoDTO videoDTO) {
        log.info("视频分页查询");
        Page<VideoBO> page = new Page<>(videoDTO.getCurrent(), videoDTO.getSize());
        VideoVO videoVO = new VideoVO();
        BeanUtils.copyProperties(videoDTO,videoVO);
        Page<VideoBO> result = videoService.getVideoList(page,videoDTO);
        return ResultTool.success(result);
    }
}
