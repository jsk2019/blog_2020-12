package com.ws.bighomeworkfirst.controller;


import com.ws.bighomeworkfirst.domain.Comment;
import com.ws.bighomeworkfirst.domain.CommentPacket;
import com.ws.bighomeworkfirst.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    /**
     * 提交评论
     * @param comment
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String commitComment(@RequestBody Comment comment){
        return commentService.commitComment(comment);
    }

    /**
     * 获取所有评论
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

    /**
     * 返回指定评论的所有子评论
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/{commentId}",method = RequestMethod.GET)
    public List<Comment> getAllChidrenComment(@PathVariable Integer commentId){
        return commentService.getAllChildrenComment(commentId);
    }

    /**
     * 删评
     * @param commentId
     * @return
     */
    @RequestMapping(value = "/{commentId}",method = RequestMethod.DELETE)
    public String deleteComment(@PathVariable Integer commentId){
        return commentService.deleteComment(commentId);
    }

    @RequestMapping(value = "/article/{articleId}",method = RequestMethod.GET)
    public List<Comment> getCommentsByArticleId(@PathVariable Integer articleId){
        return commentService.getCommentsByArticleId(articleId);
    }
}
