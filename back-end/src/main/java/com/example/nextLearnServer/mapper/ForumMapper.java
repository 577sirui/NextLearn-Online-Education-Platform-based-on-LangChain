package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ForumMapper {
    public Boolean publishQuestion(Question question);
    public Boolean bookmarkQuestion(String questionId);
}
