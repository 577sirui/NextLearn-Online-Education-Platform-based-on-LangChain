package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.CourseMapper;
import com.example.nextLearnServer.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Course> selectAllCourses() {
        try{
            String url = dataSource.getConnection().getMetaData().getURL();

            System.out.println(url);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return courseMapper.selectAllCourses();
    }

    @Override
    public List<Course> selectCoursesByTeacherId(int teacherId) {
        return courseMapper.selectCoursesByTeacherId(teacherId);
    }

    @Override
    public List<Course> selectCoursesByStudentId(int studentId) {
        return courseMapper.selectCoursesByStudentId(studentId);
    }

    @Override
    public List<Course> selectCoursesByName(String keyword) {
        return courseMapper.selectCoursesByName(keyword);
    }
}
