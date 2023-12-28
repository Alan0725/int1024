package com.int1024.common.util.net;

import lombok.Getter;

/**
 * @author 双料特工・钏钐钾
 * @description 状态码
 * @createTime 2023-10-13
 */
public enum ResultCode implements IErrorCode {
    /**
     * 成功
     */
    SUCCESS(200, "Success"),
    /**
     * 失败（此处为业务处理失败）
     */
    FAIL(205, "Fail"),
    /**
     * 无效参数
     */
    INVALID_INPUT(400, "Invalid input data"),
    /**
     * 无权限
     */
    UNAUTHORIZED(401, "Unauthorized access"),
    /**
     * 禁止访问
     */
    FORBIDDEN(403, "Access forbidden"),
    /**
     * 资源不存在
     */
    NOT_FOUND(404, "Resource not found"),
    /**
     * 媒体类型不受服务器支持
     */
    UNSUPPORTED_TYPE(415, "Unsupported media type"),
    /**
     * 服务器错误
     */
    INTERNAL_SERVER_ERROR(500, "Internal server error");

    /**
     * 状态码
     */
    @Getter
    private final int code;

    /**
     * 错误信息
     */
    @Getter
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
