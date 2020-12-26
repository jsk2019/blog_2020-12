package com.ws.bighomeworkfirst.dao;

import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Comment;

import java.util.List;

public interface IArticleDao {
    /**
     * 提交博文
     * @param article
     */
    void commitArticle(Article article);

    /**
     * 获取所有博文
     */
    List<Article> getAllArticle();

    /**
     * 根据 博文id获取博文（包括对应评论）
     * @param articleId
     * @return
     */
    Article getArticleByArticleId(Integer articleId);

    /**
     * 博文 分页查询
     * @param startIndex
     * @param num
     * @return
     */
    List<Article> getArticlePaged(Integer startIndex,Integer num);

    /**
     * 博文 标题模糊搜索
     * @param keyWord
     * @return
     */
    List<Article> getArticleTitleVague(String keyWord);

    /**
     * 博文 内容模糊搜索
     * @param keyWord
     * @return
     */
    List<Article> getArticleContentVague(String keyWord);

    /**
     * 根据 博文id删除 博文
     * @param articleId
     * @return
     */
    void deleteArticleByArticleId(Integer articleId);

    /**
     * 根据Id 获取浏览量
     * @param articleId
     * @return
     */
    Integer getArticlesViewsByArticleId(Integer articleId);

    /**
     * 根据Id 设置浏览量
     * @param articleId
     * @return
     */
    void setArticleViewsByArticleId(Integer articleId,Integer views);

    /**
     * 修改博文
     * @param article
     */
    void changeArticle(Article article);

    /**
     * 获取总数
     * @return
     */
    Integer getTotalNum();

    /**
     * 用于导航栏的search
     * @param keyWord
     * @return
     */
    List<Article> getArticleBySearch(String keyWord);
}
