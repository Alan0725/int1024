package com.int1024.tail.service.impl;

import com.int1024.common.exception.Asserts;
import com.int1024.tail.model.User;
import com.int1024.tail.repository.cache.UserCache;
import com.int1024.tail.repository.mapper.UserMapper;
import com.int1024.tail.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author 双料特工・钏钐钾
 * @description 用户Service
 * @createTime 2023-10-12
 */
@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    UserCache userCache;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override
    public int registerUser(@NonNull User user) {
        // 验证用户名唯一性 && 手机号唯一性
        List<User> userList = userMapper.selectUserByUserNameOrPhoneNumber(user.getUsername(), user.getPhoneNumber());
        if (!CollectionUtils.isEmpty(userList)) {
            return 0;
        }
        if (this.userMapper.insertUser(user) > 0) {
            return user.getId();
        }
        return 0;
    }

    @Override
    public User getUser(int userId) {
        User user = userCache.getByUserId(userId);
        if (Objects.isNull(user)) {
            Asserts.fail("用户不存在");
        }
        return user;
    }
}
