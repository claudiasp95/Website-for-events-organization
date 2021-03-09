package com.sda.websiteforeventsorg.services;

import com.sda.websiteforeventsorg.entities.Comment;
import com.sda.websiteforeventsorg.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.getOne(id);
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment, long id) {
        try {
            Optional<Comment> newComment = Optional.ofNullable(comment);
            Comment oldComment = commentRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Comment not found."));
            oldComment.setContent(newComment.map(Comment::getContent).orElse(oldComment.getContent()));
            oldComment.setEvent(newComment.map(Comment::getEvent).orElse(oldComment.getEvent()));
            oldComment.setUser(newComment.map(Comment::getUser).orElse(oldComment.getUser()));

            return commentRepository.save(oldComment);
        } catch (Exception e){
            throw new RuntimeException("Comment not found.");
        }
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }
}
