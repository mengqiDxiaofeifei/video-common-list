package com.zhou.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhou.common.utils.ShortUUID;
import com.zhou.dao.VideoDao;
import com.zhou.domain.bo.VideoBO;
import com.zhou.domain.dto.VideoDTO;
import com.zhou.entity.Video;
import com.zhou.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description 视频表（Video）表服务接口实现
 * @Author houjun
 * @Date 2020/5/12 23:14
 * @since:
 * @copyright:
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoDao videoDao;


    @Override
    public int insert(Video video) {
        video.setCreateTime(new Date());
        video.setUpdateTime(new Date());
        video.setDownTime(new Date());
        video.setUploadTime(new Date());
        //默认为审核中
        video.setStatus(0);
        video.setUuid(ShortUUID.generate());
        return videoDao.insert(video);
    }

    @Override
    public Page<VideoBO> getVideoList(Page<VideoBO> page, VideoDTO videoDTO) {
        page.setRecords(videoDao.getVideoList(page,videoDTO));
        return page;
    }

}
