package com.int1024.tail.controller;

import com.int1024.common.util.net.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 双料特工・钏钐钾
 * @description 错误
 * @createTime 2023-10-13
 */
@Controller
public class CustomErrorController implements ErrorController {

    public static String CODE_KEY = "errorCode";
    public static String MESSAGE_KEY = "errorMessage";
    public static String STACK_TRACE_KEY = "errorStackTrace";
    public static String ERROR_PATH = "error";

    @RequestMapping("/error")
    public String handleError() {
        return ERROR_PATH;
    }

    @RequestMapping("/error/400")
    public String error400(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.INVALID_INPUT.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.INVALID_INPUT.getMessage());
        return ERROR_PATH;
    }

    @RequestMapping("/error/401")
    public String error401(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.UNAUTHORIZED.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.UNAUTHORIZED.getMessage());
        return ERROR_PATH;
    }

    @RequestMapping("/error/403")
    public String error403(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.FORBIDDEN.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.FORBIDDEN.getMessage());
        return ERROR_PATH;
    }

    @RequestMapping("/error/404")
    public String error404(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.NOT_FOUND.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.NOT_FOUND.getMessage());
        return ERROR_PATH;
    }

    @RequestMapping("/error/415")
    public String error415(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.UNSUPPORTED_TYPE.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.UNSUPPORTED_TYPE.getMessage());
        return ERROR_PATH;
    }

    @RequestMapping("/error/500")
    public String error500(Model model) {
        model.addAttribute(CODE_KEY, ResultCode.INTERNAL_SERVER_ERROR.getCode());
        model.addAttribute(MESSAGE_KEY, ResultCode.INTERNAL_SERVER_ERROR.getMessage());
        return ERROR_PATH;
    }
}
