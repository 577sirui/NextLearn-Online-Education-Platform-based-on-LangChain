package com.example.nextLearnServer.controller;


import com.example.nextLearnServer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/getAllStudent")
    public Object getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/student/getStudentById")
    public Object getStudentById(HttpServletRequest req) {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        return studentService.getStudentById(String.valueOf(studentId));
    }

    @PostMapping("/student/updateStudent")
    public void updateStudent() {
        studentService.updateStudent();
    }
}
