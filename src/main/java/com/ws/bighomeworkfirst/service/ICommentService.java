package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.Comment;
import com.ws.bighomeworkfirst.domain.CommentPacket;

import java.util.List;

public interface ICommentService {

    String commitComment(Comment comment);

    List<Comment> getAllComment();

    List<Comment> getAllChildrenComment(Integer commentId);

    String deleteComment(Integer commentId);

    List<Comment> getCommentsByArticleId(Integer articleId);
}
