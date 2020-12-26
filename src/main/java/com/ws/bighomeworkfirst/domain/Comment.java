package com.ws.bighomeworkfirst.domain;


import java.sql.Date;
import java.util.List;

public class Comment {
    private Integer comment_id;

    private String comment_user_name;

    private Integer comment_article_id;

    private Integer comment_like_count;

    private Date comment_date;

    private String comment_content;

    private List<ChildComment> childComments;

    // 主表引用
    private Article article;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_user_name() {
        return comment_user_name;
    }

    public void setComment_user_name(String comment_user_name) {
        this.comment_user_name = comment_user_name;
    }

    public Integer getComment_article_id() {
        return comment_article_id;
    }

    public void setComment_article_id(Integer comment_article_id) {
        this.comment_article_id = comment_article_id;
    }

    public Integer getComment_like_count() {
        return comment_like_count;
    }

    public void setComment_like_count(Integer comment_like_count) {
        this.comment_like_count = comment_like_count;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<ChildComment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<ChildComment> childComments) {
        this.childComments = childComments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", comment_user_name='" + comment_user_name + '\'' +
                ", comment_article_id=" + comment_article_id +
                ", comment_like_count=" + comment_like_count +
                ", comment_date=" + comment_date +
                ", comment_content='" + comment_content + '\'' +
                ", childComments=" + childComments +
                ", article=" + article +
                '}';
    }
}

