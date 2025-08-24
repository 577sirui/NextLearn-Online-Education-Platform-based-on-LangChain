package com.example.nextLearnServer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private int id;
    private Date enrollmentDate;
    private String major;
    private List<Integer> courses;
}
