package com.int1024.repository.cache;

import com.int1024.tail.model.User;
import com.int1024.tail.repository.cache.UserCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author 双料特工・钏钐钾
 * @description 用户缓存单元测试
 * @createTime 2023-10-12
 */
@SpringBootTest
public class UserCacheTest {

    @Autowired
    private UserCache userCache;

    @Test
    public void testSetAndGetUser() {
        User user = new User();
        user.setId(1);
        user.setNickName("小尾巴");
        userCache.setUser(user);

        User cachedUser = userCache.getByUserId(1);

        assertNotNull(cachedUser);
        assertEquals(user.getId(), cachedUser.getId());
        assertEquals(user.getNickName(), cachedUser.getNickName());
    }

    @Test
    public void testGetNonExistentUser() {
        User cachedUser = userCache.getByUserId(999);

        assertNull(cachedUser);
    }
}
