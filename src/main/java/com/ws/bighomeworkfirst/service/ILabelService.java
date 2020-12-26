package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.Article;
import com.ws.bighomeworkfirst.domain.Label;

import java.util.List;

public interface ILabelService {

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

    /**
     * 获取标签总数
     * @return
     */
    Integer getLabelNum();

    /**
     * 添加标签
     * @param label
     * @return
     */
    String commitLabel(Label label);

    /**
     * 分页获取标签
     * @param pageNow
     * @param num
     * @return
     */
    List<Label> getLabelPaged(Integer pageNow,Integer num);

    /**
     * 根据标签名称 获取对应文章数目
     * @param labelName
     * @return
     */
    Integer getNumByName(String labelName);
}
