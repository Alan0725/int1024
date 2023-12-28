package com.int1024.common.exception;

import com.int1024.common.util.ExceptionUtil;
import com.int1024.common.util.net.NetUtil;
import com.int1024.common.util.net.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.int1024.tail.controller.CustomErrorController.*;

/**
 * @author 双料特工・钏钐钾
 * @description 全局异常处理
 * @createTime 2023-10-13
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public Object handleCustomException(final ApiException e, HttpServletRequest request, Model model) {
        logError(e);
        // 判断请求是否是Ajax请求
        if (NetUtil.isAjax(request)) {
            return Result.error(e.getErrorCode().getCode(), e.getMessage());
        } else {
            // 非Ajax请求，重定向到错误页面并传递错误信息到模型
            model.addAttribute(CODE_KEY, e.getErrorCode().getCode());
            model.addAttribute(MESSAGE_KEY, e.getErrorCode().getMessage());
            model.addAttribute(STACK_TRACE_KEY, ExceptionUtil.getStackTraceAsString(e));
            return ERROR_PATH;
        }
    }


    private void logError(Throwable t) {
        if (t instanceof ApiException) {
            log.debug(t.getMessage());
        } else if (ExceptionUtil.isClientAbortException(t)) {
            log.debug(t.getMessage(), t);
        } else {
            log.error(t.getMessage(), t);
        }
    }
}
