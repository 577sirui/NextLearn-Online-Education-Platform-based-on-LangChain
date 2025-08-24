package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Comment;
import com.example.nextLearnServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/addComment")
    public void addComment(Comment comment) {
         commentService.addComment(comment);
    }

    @DeleteMapping("/comment/deleteComment/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }
}
