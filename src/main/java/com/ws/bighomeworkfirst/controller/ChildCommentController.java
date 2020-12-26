package com.ws.bighomeworkfirst.controller;

import com.ws.bighomeworkfirst.domain.ChildComment;
import com.ws.bighomeworkfirst.service.IChildCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/childComments")
public class ChildCommentController {

    @Autowired
    private IChildCommentService childCommentService;

    @CrossOrigin
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String commitChildComment(@RequestBody ChildComment childComment){
        return childCommentService.commitChildComment(childComment);
    }

    @RequestMapping(value = "/{childCommentId}",method = RequestMethod.DELETE)
    public String deleteChildComment(@PathVariable Integer childCommentId){
        return childCommentService.deleteChildComment(childCommentId);
    }
}
