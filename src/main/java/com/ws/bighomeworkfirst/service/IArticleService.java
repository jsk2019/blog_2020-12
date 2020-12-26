package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.Article;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IArticleService {

    String commitArticle(Article article);

    List<Article> getAllArticle();

    Article getArticleByArticleId(Integer articleId);

    List<Article> getArticlePaged(Integer pageNow,Integer num);

    List<Article> getArticleTitleVague(String keyWord);

    List<Article> getArticleContentVague(String keyWord);

    String deleteArticleByArticleId(Integer articleId);

    String increaseViewsByArticleId(Integer articleId);

    String setArticleViewsByArticleId(Integer articleId,Integer views) throws Exception;

    String changeArticle(Article article);

    Integer getTotalNum();

    //用于导航栏搜索的
    List<Article> getArticleBySearch(String keyWord);
}
