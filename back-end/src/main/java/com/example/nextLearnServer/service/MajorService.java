package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Major;

import java.util.List;

public interface MajorService {
    //获取软协的主修方向信息
    public List<Major> getMajorMsg();
}
