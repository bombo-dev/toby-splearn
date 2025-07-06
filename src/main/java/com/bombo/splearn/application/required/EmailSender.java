package com.bombo.splearn.application.required;

import com.bombo.splearn.domain.EmailVo;

public interface EmailSender {
    void send(EmailVo email, String subject, String body);
}
