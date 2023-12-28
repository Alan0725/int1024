package com.int1024.tail.controller;

import com.int1024.common.util.net.Result;
import com.int1024.tail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 双料特工・钏钐钾
 * @description 用户Controller
 * @createTime 2023-10-13
 */
@RestController
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public Result<?> getUser(@RequestParam(value = "userId") int userId) {
        return Result.success(this.userService.getUser(userId));
    }
}
