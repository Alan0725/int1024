package com.int1024.tail.repository.cache;

import com.int1024.tail.model.User;
import com.int1024.tail.repository.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author 双料特工・钏钐钾
 * @description 用户缓存
 * @createTime 2023-10-12
 */
@Component
public class UserCache {
    private static final String USER_CACHE_PREFIX = "user:";

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private static String getKey(int userId) {
        return USER_CACHE_PREFIX + userId;
    }

    /**
     * 获取用户
     * @param userId    用户ID
     * @return  用户
     */
    public User getByUserId(int userId) {
        User user = redisTemplate.opsForValue().get(getKey(userId));
        if (Objects.isNull(user)) {
           synchronized (getKey(userId)) {
               user = this.userMapper.selectUserById(userId);
               if (Objects.nonNull(user)) {
                   setUser(user);
               }
           }
        }
        return user;
    }

    /**
     * 设置用户
     * @param user  用户
     */
    public void setUser(User user) {
        synchronized (getKey(user.getId())) {
            redisTemplate.opsForValue().set(getKey(user.getId()), user);
            redisTemplate.expire(getKey(user.getId()), 1, TimeUnit.DAYS);
        }
    }
}
