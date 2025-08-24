package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {
    private int id;
    private List<String> message;
    private Date conversationDate;
    private int teacherId;
    private int studentId;
    private int parentId;
}
