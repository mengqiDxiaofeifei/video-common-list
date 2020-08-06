package com.zhou.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 0.1
 * @Description 封装返回得json对象
 * @Author houjun
 * @Date 2020/3/17 22:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public Result(boolean success) {
        this.success = success;
        this.code = success? ResultCode.SUCCESS.getCode():ResultCode.FAIL.getCode();
        this.message = success? ResultCode.SUCCESS.getMessage():ResultCode.FAIL.getMessage();
    }

    public Result(boolean success, ResultCode resultCode) {
        this.success = success;
        this.code = success? ResultCode.SUCCESS.getCode(): (resultCode == null? ResultCode.FAIL.getCode(): resultCode.getCode());
        this.message = success? ResultCode.SUCCESS.getMessage(): (resultCode == null? ResultCode.FAIL.getMessage(): resultCode.getMessage());
    }

    public Result(boolean success, T data) {
        this.success = success;
        this.code = success? ResultCode.SUCCESS.getCode():ResultCode.FAIL.getCode();
        this.message = success? ResultCode.SUCCESS.getMessage():ResultCode.FAIL.getMessage();
        this.data = data;
    }

    public Result(boolean success, ResultCode resultCode, T data) {
        this.success = success;
        this.code = success? ResultCode.SUCCESS.getCode(): (resultCode == null? ResultCode.FAIL.getCode(): resultCode.getCode());
        this.message = success? ResultCode.FAIL.getMessage(): (resultCode == null? ResultCode.FAIL.getMessage(): resultCode.getMessage());
        this.data = data;
    }

}
