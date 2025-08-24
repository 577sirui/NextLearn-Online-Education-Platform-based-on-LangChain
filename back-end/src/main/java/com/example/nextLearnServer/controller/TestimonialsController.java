package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.TestimonialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestimonialsController {

    @Autowired
    private TestimonialsService testimonialsService;

    //Get member rating information
    @GetMapping("/testimonials/getAll")
    public Object getAllTestimonials() {
        return testimonialsService.getAllTestimonials();
    }
}
