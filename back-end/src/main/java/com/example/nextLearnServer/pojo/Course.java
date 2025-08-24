package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private int id;
    private String name;
    private String description;
    private int credit;
    private int teacherId;
    //private List<Integer> students;
}
