package com.int1024.tail.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 双料特工・钏钐钾
 * @description 错误
 * @createTime 2023-10-13
 */
@Controller
public class CustomErrorController  implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }

}
