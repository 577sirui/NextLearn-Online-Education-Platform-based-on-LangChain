package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/major/getMajorMsg")
    public Object getMajorMsg() {
        return majorService.getMajorMsg();
    }
}
