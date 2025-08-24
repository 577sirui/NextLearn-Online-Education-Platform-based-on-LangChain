package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Log;
import com.example.nextLearnServer.service.LogService;
import com.example.nextLearnServer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private LogService logService;

    //Get all member information
    @GetMapping("/member/getAllMsg")
    public Object getAllMsg() {
        Log log = new Log();
        log.setOperator("domestic consumer");
        log.setOperate("Hot spot statistics");
        log.setType("1");
        logService.saveLog(log);
        return memberService.getAllMemberMsg();
    }

    //Get the information displayed in the new interface
    @GetMapping("/member/getAllShowing")
    public Object getShowing() {
        return memberService.getShowingMsg();
    }

    //Get the number of members (after weight removal)
    @GetMapping("/member/getGrade")
    public Object getGrade() {
        return memberService.getGrade();
    }

    //Get a class of members
    @GetMapping("/member/getMsgByGrade")
    public Object getMsgByGrade(HttpServletRequest req) {
        String grade = req.getParameter("grade");
        return memberService.getMsgByGrade(grade);
    }
}
