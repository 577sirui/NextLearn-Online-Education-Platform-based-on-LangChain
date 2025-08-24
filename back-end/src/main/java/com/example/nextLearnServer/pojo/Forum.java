package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forum implements Serializable {
    private int id;
    private String title;
    private Question question;
    private int category;
    //    private List<Teacher> teacherList;
    //    private List<Student> studentList;
}
