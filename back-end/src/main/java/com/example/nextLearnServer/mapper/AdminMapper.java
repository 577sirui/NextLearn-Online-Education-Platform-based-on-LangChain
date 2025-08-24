package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //Store registration information
    public void saveRegister(Admin admin);

    //Obtain the password for comparison
    public String getPassword(String phone);
}
