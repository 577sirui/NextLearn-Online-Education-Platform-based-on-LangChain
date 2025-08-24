package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Sign;
import com.example.nextLearnServer.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

    @Autowired
    private SignService saveServiceImpl;

    //Add sign-up information
    @PostMapping("/sign/add")
    public void saveSign(Sign sign){
        saveServiceImpl.saveSign(sign);
    }

    //Get information about all applicants
    @GetMapping("/sign/getAll")
    public Object getAllSign(){
        return saveServiceImpl.queryAllSign();
    }

}
