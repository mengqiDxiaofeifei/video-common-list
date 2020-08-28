package com.zhou.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.domain.bo.VideoBO;
import com.zhou.domain.dto.VideoDTO;
import com.zhou.entity.Video;

import java.util.List;

public interface VideoDao extends BaseMapper<Video> {

//    /**
//     * 新增数据
//     *
//     * @return 影响行数
//     */
//    int insert(Video video);

    List<VideoBO> getVideoList(Page<VideoBO> page, VideoDTO videoDTO);
}