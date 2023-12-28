package com.int1024.common.util.net;
/**
 * @author 双料特工・钏钐钾
 * @description 错误码
 * @createTime 2023-10-13
 */
public interface IErrorCode {
    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
