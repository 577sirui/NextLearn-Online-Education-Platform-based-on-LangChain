package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Question;
import com.example.nextLearnServer.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForumController {
    @Autowired
    private ForumService forumService;

    @PostMapping("/forum/publishQuestion")
    public boolean publishQuestion(Question question){
        return forumService.publishQuestion(question);
    }

    @PostMapping("/forum/bookmarkQuestion")
    public boolean bookmarkQuestion(String questionId){
        return forumService.bookmarkQuestion(questionId);
    }

}
