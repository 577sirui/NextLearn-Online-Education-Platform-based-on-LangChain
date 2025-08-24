package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.StudentMapper;
import com.example.nextLearnServer.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void updateStudent() {
        studentMapper.updateStudent();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentMapper.getStudentById(studentId);
    }
}
