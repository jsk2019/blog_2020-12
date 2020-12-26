package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.dao.ICommentDao;
import com.ws.bighomeworkfirst.domain.Comment;
import com.ws.bighomeworkfirst.domain.CommentPacket;
import com.ws.bighomeworkfirst.domain.User;
import com.ws.bighomeworkfirst.service.ICommentService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private ICommentDao commentDao;

    @Override
    public String commitComment(Comment comment) {
        try{
            commentDao.commitComment(comment);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "commit comment fail";
        }
        return "comment commit ok";
    }

    @Override
    public List<Comment> getAllComment() {
        List<Comment> retList=null;
        try{
            retList=commentDao.getAllComment();
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public List<Comment> getAllChildrenComment(Integer commentId) {
        List<Comment> retList=null;
        try{
            retList=commentDao.getAllChildrenComment(commentId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public String deleteComment(Integer commentId) {
        try{
            commentDao.deleteComment(commentId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "cdelete comment fail";
        }
        return "delete commit ok";
    }



    @Override
    public List<Comment> getCommentsByArticleId(Integer articleId) {
        List<Comment> retList=null;
        try{
            retList=commentDao.getCommentsByArticleId(articleId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

}
