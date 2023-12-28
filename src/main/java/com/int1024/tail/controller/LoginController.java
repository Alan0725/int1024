package com.int1024.tail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 双料特工・钏钐钾
 * @description 登录
 * @createTime 2023-10-14
 */
@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

}
