package com.bombo.splearn.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailVoTest {

    @Test
    void invalidEmail() {
        assertThatThrownBy(() -> new EmailVo("invalid Email"))
                .isInstanceOf(IllegalArgumentException.class);

        new EmailVo("bombo@github.com");
    }

    @Test
    void equality() {
        EmailVo email1 = new EmailVo("bombo@github.com");
        EmailVo email2 = new EmailVo("bombo@github.com");

        assertThat(email1).isEqualTo(email2);
    }
}