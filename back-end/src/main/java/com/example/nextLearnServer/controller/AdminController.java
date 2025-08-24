package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Admin;
import com.example.nextLearnServer.pojo.Log;
import com.example.nextLearnServer.service.AdminService;
import com.example.nextLearnServer.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private LogService logService;

    //Add Registrant information
    @PostMapping("/admin/register")
    public void saveRegister(@RequestBody Admin admin) {
        adminService.saveRegister(admin);
        String name = admin.getName();
        Log log = new Log();
        log.setOperator(name);
        log.setOperate("注册申请");
        log.setType("0");
        logService.saveLog(log);

    }

    @PostMapping("/admin/getPassword")
    public Object getPassword(@RequestBody Map<String, String> requestData) {
        System.out.println(requestData);
        String phone = requestData.get("phone");
        System.out.println(phone);
        return adminService.getPassword(phone);
    }
}
