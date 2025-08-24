package com.example.nextLearnServer.mapper;

import com.example.nextLearnServer.pojo.Mailbox;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MailboxMapper {
    //Store mail
    public void saveMailbox(Mailbox mailbox);
    //Query all mail
    public List<Mailbox> queryAllMailbox();
}
