package com.ws.bighomeworkfirst.domain;

import java.sql.Date;
import java.util.List;

public class Article {
    private Integer article_id;

    private Integer article_user_id;

    private String article_title;

    private String article_content;

    private Integer article_views;

    private Integer article_comment_count;

    private Date article_create_date;

    private Integer article_like_count;

    // 从表 评论
    private List<Comment> comments;

    // 主表 用户 引用
    private User user;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getArticle_user_id() {
        return article_user_id;
    }

    public void setArticle_user_id(Integer article_user_id) {
        this.article_user_id = article_user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getArticle_views() {
        return article_views;
    }

    public void setArticle_views(Integer article_views) {
        this.article_views = article_views;
    }

    public Integer getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(Integer article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public Date getArticle_create_date() {
        return article_create_date;
    }

    public void setArticle_create_date(Date article_create_date) {
        this.article_create_date = article_create_date;
    }

    public Integer getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(Integer article_like_count) {
        this.article_like_count = article_like_count;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_user_id=" + article_user_id +
                ", article_title='" + article_title + '\'' +
                ", article_content='" + article_content + '\'' +
                ", article_views=" + article_views +
                ", article_comment_count=" + article_comment_count +
                ", article_create_date=" + article_create_date +
                ", article_like_count=" + article_like_count +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }
}
