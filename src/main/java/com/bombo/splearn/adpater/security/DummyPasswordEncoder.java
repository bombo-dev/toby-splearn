package com.bombo.splearn.adpater.security;

import com.bombo.splearn.domain.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return "";
    }

    @Override
    public boolean matches(String password, String passwordHash) {
        return false;
    }
}
