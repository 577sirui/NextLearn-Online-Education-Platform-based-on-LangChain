package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Testimonials;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestimonialsMapper {
    //Get all reviews
    public List<Testimonials> getAllTestimonials();
}
