package com.zhou.controller.upload;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.zhou.common.response.Result;
import com.zhou.common.response.ResultCode;
import com.zhou.common.response.ResultTool;
import com.zhou.config.TengXunYunCorsProperties;
import com.zhou.entity.SysUser;
import com.zhou.entity.Video;
import com.zhou.service.SysUserService;
import com.zhou.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * UploadController
 *
 * @author zhouhoujun
 * @date 2020/8/20
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {


    @Autowired
    private TengXunYunCorsProperties txycPro;
    @Autowired
    private VideoService videoService;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 上传道腾讯云服务器（https://cloud.tencent.com/document/product/436/10199）
     *
     * @return
     */
    @RequestMapping(value = "/videoUpload", method = RequestMethod.POST)
    public Result uploadBase(
            @RequestParam(value = "file") MultipartFile file) {
        log.info("视频上传");
        if (file == null) {
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);
        }
        String videoUrl = upload(file, 2);
        if (StringUtils.isBlank(videoUrl)) {
            return ResultTool.fail(ResultCode.TENGXUN_UPLOAD_EXPETION);
        }
        return ResultTool.success(videoUrl);
    }


    /**
     * 上传道腾讯云服务器（https://cloud.tencent.com/document/product/436/10199）
     *
     * @return
     */
    @RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
    public Result uploadBaseImg(
            @RequestParam(value = "file") MultipartFile vFile) {
        log.info("图片上传");
        if (vFile == null) {
            return ResultTool.fail(ResultCode.PARAM_IS_BLANK);
        }
        String imgUrl = upload(vFile, 1);
        if (StringUtils.isBlank(imgUrl)) {
            return ResultTool.fail(ResultCode.TENGXUN_UPLOAD_EXPETION);
        }
        return ResultTool.success(imgUrl);
    }


    /**
     * 上传道腾讯云服务器（https://cloud.tencent.com/document/product/436/10199）
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result videoInstert(
            @Valid Video video) {
        log.info("视频添加");
        SysUser user = sysUserService.getUser();
        if (user != null && user.getId() != null) {
            video.setUserId(user.getId());
            videoService.insert(video);
            return ResultTool.success(ResultCode.SUCCESS);
        } else {
            return ResultTool.fail(ResultCode.USER_CURRENT_ACCOUNT_NOT_EXIST);
        }
    }


    public String upload(MultipartFile file, Integer type) {
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(txycPro.getAccessKey(), txycPro.getSecretKey());
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(type.equals(1) ? txycPro.getBucketImg() : txycPro.getBucketVideo()));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        //type 1:图片上传    2: 视频上传
        String bucketName = type.equals(1) ? txycPro.getBucketImgName() : txycPro.getBucketVideoName();
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = null;
        try {
            localFile = File.createTempFile("temp", null);
            file.transferTo(localFile);
            // 指定要上传到 COS 上的路径
            String key = "/" + txycPro.getQianzui() + "/" + year + "/" + month + "/" + day + "/" + newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            log.info("文件上传 : {}", putObjectRequest);
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            return type.equals(1) ? txycPro.getPathImg() + putObjectRequest.getKey() : txycPro.getPathVideo() + putObjectRequest.getKey();
        } catch (IOException e) {
            return "";
        } finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }
}
