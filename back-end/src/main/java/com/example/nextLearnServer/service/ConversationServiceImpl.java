package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.ConversationMapper;
import com.example.nextLearnServer.pojo.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService{

    @Autowired
    private ConversationMapper conversationMapper;

    @Override
    public List<Conversation> selectAllConversations() {
        return conversationMapper.selectAllConversations();
    }
}
