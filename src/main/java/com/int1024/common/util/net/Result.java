package com.int1024.common.util.net;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;

/**
 * @author 双料特工・钏钐钾
 * @description 返回结果实体对象
 * @createTime 2023-10-13
 */
public final class Result<T> {
    /**
     * 状态码
     */
    @Getter
    private final int code;

    /**
     * 返回的信息
     */
    @Getter
    private final String message;

    /**
     * 返回的数据
     */
    @Getter
    private T data;

    /**
     * 成功时调用（有数据）
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(data);
    }

    /**
     * 成功时候的调用（无数据）
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS);
    }

    /**
     * 失败时调用（无数据）
     */
    public static <T> Result<T> fail() {
        return new Result<>(ResultCode.FAIL);
    }

    /**
     * 失败时调用
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.FAIL.getCode(), message);
    }

    public static <T> Result<T> error(IErrorCode code) {
        return new Result<>(code.getCode(), code.getMessage());
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }


    private Result(T data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    private Result(ResultCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public JSON toJson() {
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("message", message);
        object.put("data", data);
        return object;
    }
}
