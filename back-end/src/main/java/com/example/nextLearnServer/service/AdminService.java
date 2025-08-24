package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Admin;

public interface AdminService {
    //Store registration information
    public void saveRegister(Admin admin);

    //Obtain the password for comparison
    public String getPassword(String phone);
}
