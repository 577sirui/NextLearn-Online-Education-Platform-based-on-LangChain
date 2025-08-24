package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentMapper {
    //add comment
    void addComment(Comment comment);
    //delete comment
    void deleteComment(@Param("commentId") int commentId);

}
