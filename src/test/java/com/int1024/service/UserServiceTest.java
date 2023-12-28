package com.int1024.service;

import com.int1024.tail.model.User;
import com.int1024.tail.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author 双料特工・钏钐钾
 * @description UserService单元测试
 * @createTime 2023-10-12
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setNickName("小尾巴");
        user.setGender(0);
        user.setEmail("445585388@qq.com");
        user.setBirthday(new Date());
        user.setStatus(0);
        user.setAvatar("");
        user.setPassword("123456");
        user.setUsername("admin");
        user.setPhoneNumber("18280137021");

        int uid = userService.registerUser(user);
        if (uid <= 0) {
            Assertions.fail();
        }
    }
}
