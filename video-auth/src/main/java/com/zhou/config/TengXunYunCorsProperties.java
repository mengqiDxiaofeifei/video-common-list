package com.zhou.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * TengXunYunCorsProperties
 *
 * @author zhouhoujun
 * @date 2020/8/20
 */
@Component
@Data
public class TengXunYunCorsProperties {

    @Value("${sdk.tengxun.accessKey}")
    private String accessKey;
    @Value("${sdk.tengxun.secretKey}")
    private String secretKey;
    @Value("${sdk.tengxun.bucketImg}")
    private String bucketImg;
    @Value("${sdk.tengxun.bucketVideo}")
    private String bucketVideo;
    @Value("${sdk.tengxun.bucketImgName}")
    private String bucketImgName;
    @Value("${sdk.tengxun.bucketVideoName}")
    private String bucketVideoName;
    @Value("${sdk.tengxun.pathVideo}")
    private String pathVideo;
    @Value("${sdk.tengxun.pathImg}")
    private String pathImg;
    @Value("${sdk.tengxun.qianzui}")
    private String qianzui;

}
