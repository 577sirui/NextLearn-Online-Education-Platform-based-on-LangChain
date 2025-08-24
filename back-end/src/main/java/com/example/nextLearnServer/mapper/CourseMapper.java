package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {
    //get all courses
    List<Course> selectAllCourses();
    //get courses by teacher id
    List<Course> selectCoursesByTeacherId(int teacherId);
    //get courses by student id
    List<Course> selectCoursesByStudentId(int studentId);
    //get course by course name
    List<Course> selectCoursesByName(String keyword);
}
