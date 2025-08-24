package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private String title;
    private String content;
    private String publisher;
    private int role;
    private int category;
    private List<Integer> commentList;
    private int blogId;
    private LocalDateTime blogCreateTime;
}
