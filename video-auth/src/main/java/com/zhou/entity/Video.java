package com.zhou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Video
 *
 * @author zhouhoujun
 * @date 2020/8/20
 */
@Data
@TableName("tb_video")
public class Video {


    /**
     * id
     */
    private Integer id;

    /**
     * 唯一标识
     */
    private String uuid;

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 视频url
     */
    @NotBlank
    private String url;
    /**
     * 背景图片
     */
    @NotBlank
    private String image;
    /**
     * 标题
     */
    @NotBlank
    private String title;
    /**
     * 备注
     */
    private String remake;
    /**
     * 状态 1: 审核通过  0 : 审核中  2: 审核不通过
     */
    private Integer status;
    /**
     * 详情
     */
    private String details;

    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 下架时间
     */
    private Date downTime;
    /**
     * 更新时间
     */
    private Date updateTime;



}
