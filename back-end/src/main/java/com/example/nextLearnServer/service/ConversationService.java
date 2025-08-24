package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Conversation;

import java.util.List;

public interface ConversationService {
    List<Conversation> selectAllConversations();
}
