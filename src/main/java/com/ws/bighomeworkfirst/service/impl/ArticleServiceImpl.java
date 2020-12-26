package com.ws.bighomeworkfirst.service.impl;

import com.ws.bighomeworkfirst.dao.IArticleDao;
import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Comment;
import com.ws.bighomeworkfirst.service.IArticleService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements  IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public String commitArticle(Article article) {
        try{
            Date now=new Date(System.currentTimeMillis());
            article.setArticle_create_date(now);
            articleDao.commitArticle(article);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "commit article fail";
        }
        return "article commit ok";
    }

    @Override
    public List<Article> getAllArticle() {
        List<Article> retList=null;
        try{
            retList=articleDao.getAllArticle();
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public Article getArticleByArticleId(Integer articleId) {
        Integer views_count=-1;
        Article retArticle=null;
        try{
            views_count=getArticlesViewsByArticleId(articleId);
            setArticleViewsByArticleId(articleId,views_count+1);
            retArticle=articleDao.getArticleByArticleId(articleId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retArticle;
        }
        return retArticle;
    }

    @Override
    public List<Article> getArticlePaged(Integer pageNow, Integer num) {
        List<Article> retList=null;
        try{
            retList=articleDao.getArticlePaged((pageNow-1)*num,num);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public List<Article> getArticleTitleVague(String keyWord) {
        List<Article> retList=null;
        try{
            retList=articleDao.getArticleTitleVague("%"+keyWord+"%");
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    @Override
    public List<Article> getArticleContentVague(String keyWord) {
        List<Article> retList=null;
        try{
            retList=articleDao.getArticleContentVague("%"+keyWord+"%");
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }

    /**
     *
     * @param articleId
     * @return
     */
    @Override
    public String deleteArticleByArticleId(Integer articleId) {
        try{
            articleDao.deleteArticleByArticleId(articleId);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "delete article fail";
        }
        return "article delete ok";
    }

    @Override
    public String increaseViewsByArticleId(Integer articleId) {
        Integer views_count=-1;
        try{
            views_count=getArticlesViewsByArticleId(articleId);
            setArticleViewsByArticleId(articleId,views_count+1);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "increase views fail";
        }
        return "increase views ok";
    }


    private Integer getArticlesViewsByArticleId(Integer articleId) throws Exception{
        Integer views=-1;

        views=articleDao.getArticlesViewsByArticleId(articleId);
        sqlSession.commit();
        return views;
    }

    @Override
    public String setArticleViewsByArticleId(Integer articleId,Integer views) throws Exception{

        articleDao.setArticleViewsByArticleId(articleId,views);
        sqlSession.commit();
        return "set views ok";
    }

    @Override
    public String changeArticle(Article article) {
        try{
            articleDao.changeArticle(article);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return "change article fail";
        }
        return "article change ok";
    }

    @Override
    public Integer getTotalNum() {
        Integer retNum=-1;
        try{
            retNum=articleDao.getTotalNum();
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
        return retNum;
    }

    @Override
    public List<Article> getArticleBySearch(String keyWord) {
        List<Article> retList=null;
        try{
            retList=articleDao.getArticleBySearch("%"+keyWord+"%");
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
            return retList;
        }
        return retList;
    }


}
