package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Comment;

public interface CommentService {
    //add comment
    void addComment(Comment comment);
    //delete comment
    void deleteComment(int commentId);
}
