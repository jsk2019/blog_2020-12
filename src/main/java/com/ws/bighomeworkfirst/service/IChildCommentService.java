package com.ws.bighomeworkfirst.service;

import com.ws.bighomeworkfirst.domain.ChildComment;

public interface IChildCommentService {

    String commitChildComment(ChildComment childComment);

    String deleteChildComment(Integer childCommentId);

}
