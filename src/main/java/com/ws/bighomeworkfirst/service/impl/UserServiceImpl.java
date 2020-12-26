package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.dao.IUserDao;
import com.ws.bighomeworkfirst.domain.User;
import com.ws.bighomeworkfirst.domain.UserForLogin;
import com.ws.bighomeworkfirst.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private SqlSession sqlSession;


    @Override
    public String registerUser(User user) {
        try{
            userDao.registerUser(user);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "register fail";
        }
        return "register ok";
    }

    @Override
    public List<User> searchAll() {
        List<User> retList=null;
        try{
            retList=userDao.searchAll();
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public User getUserById(Integer userId) {
        User retUser=null;
        try{
            retUser=userDao.getUserById(userId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retUser;
        }
        return retUser;
    }

    @Override
    public Boolean Login(UserForLogin userForLogin) {
        Boolean ret=false;
        String pw="";
        try{
            pw=userDao.getPassword(userForLogin.getUserName());
            sqlSession.commit();
            if(pw.equals(userForLogin.getPassword()))
                ret=true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return ret;
    }
}
