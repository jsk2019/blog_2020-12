package com.ws.bighomeworkfirst.domain;

import java.sql.Date;

public class ChildCommentPacket {
    private Integer comment_id;
    private String comment_user_name;
    private Integer comment_like_count;
    private Date ccomment_date;
    private String comment_content;
    private Integer comment_parent_id;
    private String comment_to_user_name;

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

    public Date getCcomment_date() {
        return ccomment_date;
    }

    public void setCcomment_date(Date ccomment_date) {
        this.ccomment_date = ccomment_date;
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

    @Override
    public String toString() {
        return "ChildCommentPacket{" +
                "comment_id=" + comment_id +
                ", comment_user_name='" + comment_user_name + '\'' +
                ", comment_like_count=" + comment_like_count +
                ", ccomment_date=" + ccomment_date +
                ", comment_content='" + comment_content + '\'' +
                ", comment_parent_id=" + comment_parent_id +
                ", comment_to_user_name='" + comment_to_user_name + '\'' +
                '}';
    }
}
