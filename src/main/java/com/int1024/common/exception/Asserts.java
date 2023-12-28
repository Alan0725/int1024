package com.int1024.common.exception;

import com.int1024.common.util.net.IErrorCode;

/**
 * @author 双料特工・钏钐钾
 * @description 断言处理类，用于抛出各种API异常
 * @createTime 2023-10-13
 */
public class Asserts {
    /**
     * 失败断言
     * @param message 错误信息
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * 失败断言
     * @param errorCode 错误码对象
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    /**
     * 失败断言
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static void fail(int errorCode, String message) {
        throw new ApiException(errorCode, message);
    }
}
