package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.TestimonialsMapper;
import com.example.nextLearnServer.pojo.Testimonials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialsServiceImpl implements TestimonialsService{

    @Autowired
    private TestimonialsMapper testimonialsMapper;

    //获取所有的评价
    public List<Testimonials> getAllTestimonials() {
        return testimonialsMapper.getAllTestimonials();
    }
}
