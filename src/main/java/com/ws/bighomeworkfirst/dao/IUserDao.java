package com.ws.bighomeworkfirst.dao;

import com.ws.bighomeworkfirst.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 注册
     * @param user
     */
    void registerUser(User user);

    /**
     * 查询所有用户接口
     * @return
     */
    List<User> searchAll();

    /**
     * 返回单个用户包含 所有博文
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 根据名查密码
     * @param userName
     * @return
     */
    String getPassword(String userName);
}
