package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.User;
import com.ws.bighomeworkfirst.domain.UserForLogin;

import java.util.List;

public interface IUserService {

    String registerUser(User user);

    List<User> searchAll();

    User getUserById(Integer userId);

    Boolean Login(UserForLogin userForLogin);
}
