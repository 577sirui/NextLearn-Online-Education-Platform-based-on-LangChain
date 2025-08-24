package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.CommentMapper;
import com.example.nextLearnServer.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {

        commentMapper.addComment(comment);
    }

    @Override
    public void deleteComment(int commentId) {
        commentMapper.deleteComment(commentId);
    }
}
