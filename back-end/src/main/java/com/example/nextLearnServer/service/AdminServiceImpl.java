package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.AdminMapper;
import com.example.nextLearnServer.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public void saveRegister(Admin admin) {
        adminMapper.saveRegister(admin);
    }

    @Override
    public String getPassword(String phone) {
        return adminMapper.getPassword(phone);
    }
}
