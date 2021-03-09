package com.sda.websiteforeventsorg.controllers;

import com.sda.websiteforeventsorg.entities.Comment;
import com.sda.websiteforeventsorg.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentController {

    private final CommentService commentService;
    @GetMapping()
    public List<Comment> getAllComments(){

        return   commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable("id") long id){
        return commentService.getCommentById(id);
    }

    @PostMapping()
    public void saveComment(@RequestBody Comment comment){
        commentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@RequestBody Comment comment,@PathVariable("id") long id){
       return  commentService.updateComment(comment,id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") long id){

        commentService.deleteCommentById(id);
    }
}
