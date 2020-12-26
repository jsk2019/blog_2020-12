package com.ws.bighomeworkfirst.dao;

import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Label;
import jnr.ffi.annotations.In;

import java.util.List;

public interface ILabelDao {

    /**
     * 获取所有标签
     * @return
     */
    List<Label> getAllLabel();

    /**
     * 根据 标签id 获取所有博文
     * @return
     */
    List<Article> getArticlesByLabelId(Integer labelId);

    /**
     * 根据标签内容 获取所有博文
     * @return
     */
    List<Article> getArticlesByLabelTitle(String labelTitle);

    Integer getLabelNum();

    void commitLabel(Label label);

    List<Label> getLabelPaged(Integer startIndex,Integer num);

    Integer getNumByName(String labelName);
}
