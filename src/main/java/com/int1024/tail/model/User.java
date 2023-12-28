package com.int1024.tail.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author 双料特工・钏钐钾
 * @description 用户
 * @createTime 2023-10-12
 */
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    Integer id;
    /**
     * 用户名
     */
    String username;
    /**
     * 密码
     */
    String password;
    /**
     * 昵称
     */
    String nickName;
    /**
     * 性别
     */
    Integer gender;
    /**
     * 手机号
     */
    String phoneNumber;
    /**
     * 邮箱
     */
    String email;
    /**
     * 头像
     */
    String avatar;
    /**
     * 生日
     */
    Date birthday;
    /**
     * 用户状态
     */
    Integer status;
    /**
     * 注册时间
     */
    Date registerTime;
}
