package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.ForumMapper;
import com.example.nextLearnServer.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements ForumService{

    @Autowired
    private ForumMapper forumMapper;

    @Override
    public Boolean publishQuestion(Question question) {
        return forumMapper.publishQuestion(question);
    }

    @Override
    public Boolean bookmarkQuestion(String questionId) {
        return forumMapper.bookmarkQuestion(questionId);
    }
}
