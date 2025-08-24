package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Competition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompetitionMapper {
    //Get competition information
    public List<Competition> getCompetitionMsg();
}
