package com.int1024.tail.service;

import com.int1024.tail.model.User;

/**
 * @author 双料特工・钏钐钾
 * @description 用户Service
 * @createTime 2023-10-12
 */
public interface UserService {
    /**
     * 注册用户
     * @param user 用户信息
     * @return  用户ID
     */
    int registerUser(User user);

    /**
     * 获取用户
     * @param userId 用户Id
     * @return  用户
     */
    User getUser(int userId);
}
