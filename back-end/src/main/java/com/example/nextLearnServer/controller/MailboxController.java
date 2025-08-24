package com.example.nextLearnServer.controller;

import com.example.nextLearnServer.pojo.Mailbox;
import com.example.nextLearnServer.service.MailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailboxController {

    @Autowired
    private MailboxService mailboxService;

    @PostMapping("/mailbox/saveMailbox")
    public void saveMailbox(Mailbox mailbox) {
        mailboxService.saveMailbox(mailbox);
    }

    @GetMapping("/mailbox/getAllMail")
    public Object getAllMail() {
        return mailboxService.queryAllMailbox();
    }


}
