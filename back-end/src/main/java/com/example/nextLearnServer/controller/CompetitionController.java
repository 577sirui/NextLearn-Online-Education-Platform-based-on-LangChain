package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    //Get competition information
    @GetMapping("/competition/getCompetitionMsg")
    public Object getCompetitionMsg() {
        return competitionService.getCompetitionMsg();
    }
}
