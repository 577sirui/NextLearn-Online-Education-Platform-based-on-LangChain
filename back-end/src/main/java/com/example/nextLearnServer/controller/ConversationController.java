package com.example.nextLearnServer.controller;


import com.example.nextLearnServer.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/conversation/selectAllConversations")
    public Object selectAllConversations() {
        return conversationService.selectAllConversations();
    }
}
