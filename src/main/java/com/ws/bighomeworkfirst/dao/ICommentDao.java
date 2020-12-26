package com.ws.bighomeworkfirst.dao;

import com.ws.bighomeworkfirst.domain.Comment;

import java.util.List;

public interface ICommentDao {
    /**
     * 提交评论
     * @param comment
     */
    void commitComment(Comment comment);

    /**
     * 获取所有评论
     */
    List<Comment> getAllComment();

    /**
     * 获取某一评论的所有子评论
     * @param commentId
     * @return
     */
    List<Comment> getAllChildrenComment(Integer commentId);

    /**
     * 删评
     * @param commentId
     * @return
     */
    String deleteComment(Integer commentId);

    /**
     * 获取某一文章下所有评论 包括子评论
     * @param articleId
     * @return
     */
    List<Comment> getCommentsByArticleId(Integer articleId);
}
