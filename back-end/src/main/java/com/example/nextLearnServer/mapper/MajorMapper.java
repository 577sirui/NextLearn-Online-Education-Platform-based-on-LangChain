package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Major;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MajorMapper {
    //Get information about the major of the software Association
    public List<Major> getMajorMsg();
}
