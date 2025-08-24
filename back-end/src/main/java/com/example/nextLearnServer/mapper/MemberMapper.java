package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    //Get all the information
    public List<Member> getAllMemberMsg();

    //Get the information displayed in the new interface
    public List<Member> getShowingMsg();

    //Gets the number of member sessions
    public List<Member> getGrade();

    //Get a class of members
    public List<Member> getMsgByGrade(String grade);
}
