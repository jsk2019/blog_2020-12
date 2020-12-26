package com.ws.bighomeworkfirst.domain;


import java.sql.Date;

public class ChildComment {
    private Integer comment_id;
    private String comment_user_name;
    private Integer comment_like_count;
    private Date comment_date;
    private String comment_content;
    private Integer comment_parent_id;
    private String comment_to_user_name;
    private Comment parentComment;

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

    public Integer getComment_parent_id() {
        return comment_parent_id;
    }

    public void setComment_parent_id(Integer comment_parent_id) {
        this.comment_parent_id = comment_parent_id;
    }

    public String getComment_to_user_name() {
        return comment_to_user_name;
    }

    public void setComment_to_user_name(String comment_to_user_name) {
        this.comment_to_user_name = comment_to_user_name;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "ChildComment{" +
                "comment_id=" + comment_id +
                ", comment_user_name='" + comment_user_name + '\'' +
                ", comment_like_count=" + comment_like_count +
                ", comment_date=" + comment_date +
                ", comment_content='" + comment_content + '\'' +
                ", comment_parent_id=" + comment_parent_id +
                ", comment_to_user_name='" + comment_to_user_name + '\'' +
                ", parentComment=" + parentComment +
                '}';
    }
}
