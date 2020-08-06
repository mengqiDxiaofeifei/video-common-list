package com.zhou.common.response;


/**
 *@Description 封装返回得结果方法
 *@Author houjun
 *@Date 2020/5/16 18:48
 *@since:
 *@copyright:
 */
public class ResultTool {
    public static Result success() {
        return new Result(true);
    }

    public static <T> Result<T> success(T data) {
        return new Result(true, data);
    }

    public static Result fail() {
        return new Result(false);
    }

    public static Result fail(ResultCode resultEnum) {
        return new Result(false, resultEnum);
    }
}
