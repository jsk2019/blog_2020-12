package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.dao.IChildCommentDao;
import com.ws.bighomeworkfirst.domain.ChildComment;
import com.ws.bighomeworkfirst.service.IChildCommentService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildCommentServiceImpl implements IChildCommentService {

    @Autowired
    private IChildCommentDao childCommentDao;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public String commitChildComment(ChildComment childComment) {
        try{
            childCommentDao.commitChildComment(childComment);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "commit childComment fail";
        }
        return "childComment commit ok";
    }

    @Override
    public String deleteChildComment(Integer childCommentId) {
        try{
            childCommentDao.deleteChildComment(childCommentId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "delete childComment fail";
        }
        return "delete commit ok";
    }
}
