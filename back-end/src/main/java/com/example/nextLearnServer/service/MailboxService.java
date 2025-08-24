package com.example.nextLearnServer.service;

import com.example.nextLearnServer.pojo.Mailbox;

import java.util.List;

public interface MailboxService {
    //存储邮件
    public void saveMailbox(Mailbox mailbox);
    //查询全部邮件
    public List<Mailbox> queryAllMailbox();
}
