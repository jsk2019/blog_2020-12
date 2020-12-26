package com.ws.bighomeworkfirst.util;

import com.ws.bighomeworkfirst.dao.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/*
    用于 将 myBatis自动生成的Dao实现类 注册Bean
 */
@Component
public class DaoUtil {
    @Autowired
    private SqlSession sqlSession;

    @Bean
    public IUserDao getUserDao(){
        return sqlSession.getMapper(IUserDao.class);
    }

    @Bean
    public IArticleDao getArticleDao(){
        return sqlSession.getMapper(IArticleDao.class);
    }

    @Bean
    public ICommentDao getCommentDao(){
        return sqlSession.getMapper(ICommentDao.class);
    }

    @Bean
    public ILabelDao getLabelDao(){ return sqlSession.getMapper(ILabelDao.class); }

    @Bean
    public IChildCommentDao getChildCommentDao(){return sqlSession.getMapper(IChildCommentDao.class);}
}
