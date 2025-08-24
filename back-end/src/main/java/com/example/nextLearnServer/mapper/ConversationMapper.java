package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Conversation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConversationMapper {
    List<Conversation> selectAllConversations();
}
