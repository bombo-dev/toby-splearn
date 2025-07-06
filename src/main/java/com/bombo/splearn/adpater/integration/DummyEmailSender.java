package com.bombo.splearn.adpater.integration;

import com.bombo.splearn.application.required.EmailSender;
import com.bombo.splearn.domain.EmailVo;
import org.springframework.stereotype.Component;

@Component
public class DummyEmailSender implements EmailSender {

    @Override
    public void send(EmailVo email, String subject, String body) {

    }
}
