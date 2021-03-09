package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Comment;


import java.util.List;


public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(long id);
    void createComment(Comment comment);
    Comment updateComment(Comment comment, long id);
    void deleteCommentById(long id);

}
