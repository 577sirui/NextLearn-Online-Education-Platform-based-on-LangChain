package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Testimonials;

import java.util.List;

public interface TestimonialsService {
    //获取所有的评价
    public List<Testimonials> getAllTestimonials();
}
