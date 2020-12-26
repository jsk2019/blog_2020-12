package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.dao.ILabelDao;
import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Label;
import com.ws.bighomeworkfirst.service.ILabelService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements ILabelService {

    @Autowired
    private ILabelDao labelDao;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Label> getAllLabel() {
        List<Label> retLabels=null;
        try{
            retLabels=labelDao.getAllLabel();
            sqlSession.commit();
        }catch (Exception ex){
            System.out.println(ex);
            return retLabels;
        }

        return retLabels;
    }

    @Override
    public List<Article> getArticlesByLabelId(Integer labelId) {
        List<Article> retArticles=null;
        try{
            retArticles=labelDao.getArticlesByLabelId(labelId);
            sqlSession.commit();
        }catch (Exception ex){
            System.out.println(ex);
            return retArticles;
        }

        return retArticles;
    }

    @Override
    public List<Article> getArticlesByLabelTitle(String labelTitle) {
        List<Article> retArticles=null;
        try{
            retArticles=labelDao.getArticlesByLabelTitle(labelTitle);
            sqlSession.commit();
        }catch (Exception ex){
            System.out.println(ex);
            return retArticles;
        }

        return retArticles;
    }

    @Override
    public Integer getLabelNum() {
        Integer retNum=-1;
        try{
            retNum=labelDao.getLabelNum();
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
        return retNum;
    }

    @Override
    public String commitLabel(Label label) {
        try{
            labelDao.commitLabel(label);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "commit label fail";
        }
        return "label commit ok";
    }

    @Override
    public List<Label> getLabelPaged(Integer pageNow, Integer num) {
        List<Label> retLabels=null;
        try{
            retLabels=labelDao.getLabelPaged((pageNow-1)*num,num);
            sqlSession.commit();
        }catch (Exception ex){
            System.out.println(ex);
            return retLabels;
        }

        return retLabels;
    }

    @Override
    public Integer getNumByName(String labelName) {
        Integer retNum=-1;
        try{
            retNum=labelDao.getNumByName(labelName);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
        return retNum;
    }
}
