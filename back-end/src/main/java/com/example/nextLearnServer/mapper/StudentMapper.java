package com.example.nextLearnServer.mapper;


import com.example.nextLearnServer.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    void updateStudent();
    List<Student> getAllStudent();
    Student getStudentById(String studentId);
}
