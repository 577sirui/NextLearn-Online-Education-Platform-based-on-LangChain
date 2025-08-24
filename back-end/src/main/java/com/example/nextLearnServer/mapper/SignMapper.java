package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SignMapper {
    public void saveSign(Sign sign);
    public List<Sign> queryAllSign();
}
