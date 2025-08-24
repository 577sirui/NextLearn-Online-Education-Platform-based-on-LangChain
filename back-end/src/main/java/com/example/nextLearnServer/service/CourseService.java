package com.example.nextLearnServer.service;


import com.example.nextLearnServer.pojo.Course;

import java.util.List;

public interface CourseService {
    //get all courses
    List<Course> selectAllCourses();
    //get courses by teacher id
    List<Course> selectCoursesByTeacherId(int teacherId);
    //get courses by student id
    List<Course> selectCoursesByStudentId(int studentId);
    //get course by course name
    List<Course> selectCoursesByName(String keyword);
}
