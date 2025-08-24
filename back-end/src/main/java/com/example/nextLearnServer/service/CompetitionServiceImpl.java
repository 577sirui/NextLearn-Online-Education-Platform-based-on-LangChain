package com.example.nextLearnServer.service;

import com.example.nextLearnServer.mapper.CompetitionMapper;
import com.example.nextLearnServer.pojo.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService{

    @Autowired
    private CompetitionMapper competitionMapper;

    @Override
    public List<Competition> getCompetitionMsg() {
        return competitionMapper.getCompetitionMsg();
    }
}
