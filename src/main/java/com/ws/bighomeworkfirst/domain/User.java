package com.ws.bighomeworkfirst.domain;


import java.sql.Date;
import java.util.List;

public class User {
    private Integer user_id;

    private String user_name;

    private String user_sex;

    private String user_password;

    private String user_email;

    private String user_photo;

    private Date user_registration_time;

    private Date user_birthday;

    private Integer user_age;

    private Integer user_telephone_number;

    private String user_nickname;

    // 用户博文一对多
    private List<Article> articles;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public Date getUser_registration_time() {
        return user_registration_time;
    }

    public void setUser_registration_time(Date user_registration_time) {
        this.user_registration_time = user_registration_time;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public Integer getUser_telephone_number() {
        return user_telephone_number;
    }

    public void setUser_telephone_number(Integer user_telephone_number) {
        this.user_telephone_number = user_telephone_number;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_registration_time=" + user_registration_time +
                ", user_birthday=" + user_birthday +
                ", user_age=" + user_age +
                ", user_telephone_number=" + user_telephone_number +
                ", user_nickname='" + user_nickname + '\'' +
                ", articles=" + articles +
                '}';
    }
}
