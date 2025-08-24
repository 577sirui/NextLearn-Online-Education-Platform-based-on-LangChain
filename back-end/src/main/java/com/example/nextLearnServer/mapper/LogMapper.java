package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {
    //Store operation logs
    public void saveLog(Log log);
}
