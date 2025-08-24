package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Student;

import java.util.List;

public interface StudentService {
    void updateStudent();
    List<Student> getAllStudent();
    Student getStudentById(String studentId);
}
