package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Log;

public interface LogService {
    //存储操作日志信息
    public void saveLog(Log log);
}
