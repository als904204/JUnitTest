package com.meta.junit.Util;

import org.springframework.stereotype.Component;

// 가짜구현체
@Component // IOC 컨테이너 등록
public class MailSenderStub implements MailSender{
    @Override
    public boolean send() {
        return true;
    }
}
