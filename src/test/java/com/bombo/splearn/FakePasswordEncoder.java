package com.bombo.splearn;

import com.bombo.splearn.domain.PasswordEncoder;

public class FakePasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return password.toUpperCase();
    }

    @Override
    public boolean matches(String password, String passwordHash) {
        return encode(password).equals(passwordHash);
    }
}
