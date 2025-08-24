package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Question;

public interface ForumService {
    public Boolean publishQuestion(Question question);
    public Boolean bookmarkQuestion(String questionId);
}
