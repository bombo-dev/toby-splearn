package com.bombo.splearn.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @DisplayName("회원을 생성 할 수 있다.")
    @Test
    void createMember() {
        // given
        Long id = 1L;
        String email = "bombo-dev@github.com";
        String nickname = "bombo";
        String password = "password";
        var member = Member.create(id, email, nickname, password);

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }
}