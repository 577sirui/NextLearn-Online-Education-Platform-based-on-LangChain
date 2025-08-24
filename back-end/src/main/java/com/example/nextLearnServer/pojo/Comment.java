package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable{
    private int role;
    private String content;
    private String publisher;
    //
    private LocalDateTime createTime;
    private int commentId;
    private int blogId;

}
