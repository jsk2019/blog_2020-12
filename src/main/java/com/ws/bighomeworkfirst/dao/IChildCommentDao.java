package com.ws.bighomeworkfirst.dao;

import com.ws.bighomeworkfirst.domain.ChildComment;

public interface IChildCommentDao {

    void commitChildComment(ChildComment childComment);

    void deleteChildComment(Integer childCommentId);

}
