package com.meta.junit.Util;

import org.springframework.stereotype.Component;

public class MailSenderAdapter implements MailSender {

//    private Mail mail;
//
//    public MailSenderAdapter() {
//        this.mail = new Mail();
//    }

    @Override
    public boolean send() {
        return true;
    }
}
