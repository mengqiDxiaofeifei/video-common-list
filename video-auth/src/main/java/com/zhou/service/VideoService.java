package com.zhou.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.domain.bo.VideoBO;
import com.zhou.domain.dto.VideoDTO;
import com.zhou.entity.Video;

/**
 * @version 0.1
 * @Description 视频（video）表服务接口
 * @Author houjun
 * @Date 2020/4/7 22:35
 */
public interface VideoService {

    /**
     * 插入
     *
     * @return 实例对象
     */
    int insert(Video video);


    Page<VideoBO> getVideoList(Page<VideoBO> page, VideoDTO videoDTO);
}
