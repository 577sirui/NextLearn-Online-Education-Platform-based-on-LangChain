package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.LogMapper;
import com.example.nextLearnServer.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogMapper logMapper;

    @Override
    public void saveLog(Log log) {
        logMapper.saveLog(log);
    }
}
