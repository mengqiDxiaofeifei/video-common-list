package com.zhou.domain.bo;

import lombok.Data;

import java.util.Date;

/**
 * VideoBO
 *
 * @author zhouhoujun
 * @date 2020/8/27
 */
@Data
public class VideoBO {
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
    private String userId;
    /**
     * 视频url
     */
    private String url;
    /**
     * 背景图片
     */
    private String image;
    /**
     * 标题
     */
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
    /**
     * 用户名
     */
    private String account;


}
