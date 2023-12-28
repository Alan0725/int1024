package com.int1024.tail.repository.mapper;

import com.int1024.tail.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 双料特工・钏钐钾
 * @description 用户Mapper
 * @createTime 2023-10-12
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增用户
     * @param user  用户
     */
    int insertUser(@Param("user") User user);

    /**
     * 查询用户
     * @param userName      用户名
     * @param phoneNumber   手机号
     * @return  用户列表
     */
    List<User> selectUserByUserNameOrPhoneNumber(@Param("userName") String userName, @Param("phoneNumber") String phoneNumber);

    /**
     * 查询用户
     * @param userId    用户ID
     * @return  用户
     */
    User selectUserById(@Param("userId") int userId);
}
