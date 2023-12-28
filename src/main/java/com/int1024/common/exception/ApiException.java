package com.int1024.common.exception;

import com.int1024.common.util.net.IErrorCode;
import com.int1024.common.util.net.ResultCode;

/**
 * @author 双料特工・钏钐钾
 * @description API异常
 * @createTime 2023-10-13
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(String message) {
        super(message);
        this.errorCode = new IErrorCode() {
            @Override
            public int getCode() {
                return ResultCode.FAIL.getCode();
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(int errorCode, String message) {
        super(message);
        this.errorCode = new IErrorCode() {
            @Override
            public int getCode() {
                return errorCode;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}