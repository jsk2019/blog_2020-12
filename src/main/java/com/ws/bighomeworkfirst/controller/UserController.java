
package com.ws.bighomeworkfirst.controller;

import com.ws.bighomeworkfirst.domain.TokenEntity;
import com.ws.bighomeworkfirst.domain.User;
import com.ws.bighomeworkfirst.domain.UserForLogin;
import com.ws.bighomeworkfirst.service.IUserService;
import com.ws.bighomeworkfirst.util.JWTutils;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 测试接口
     * @return
     */
    @RequestMapping(value = "/hello",method =RequestMethod.GET )
    public String test(){
        return "Hello";
    }

    /**
     * controller层 用户注册
     * @param user
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String registerUser(@RequestBody User user){

        return userService.registerUser(user);
    }

    /**
     * controller层 查询所有用户
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> searchAll(){
        return userService.searchAll();
    }

    /**
     * controller层 查询单个用户 并包含所有博文
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }

    /**
     * 登陆
     * @param userForLogin
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> Login(@RequestBody UserForLogin userForLogin){
        Map<String,Object> map = new HashMap<>();
        Boolean flag =  userService.Login(userForLogin);
        if (flag == true){
            Map<String,String> payload = new HashMap<>();
            payload.put("id",userForLogin.getUserName());
            String token = JWTutils.getToken(payload);
            map.put("state",true);
            map.put("msg","success");
            map.put("token",token);
           }
        else {
            map.put("state",false);
            map.put("msg","fail");
        }
        return map;
    }

    @PostMapping(value = "/verify")
    public Object verify(@RequestBody TokenEntity tokenEntity){
        try {
            JWTutils.verify(tokenEntity.getKey_token());
        }catch (Exception e){
            return "fail";
        }
        return "ok";
    }
}
