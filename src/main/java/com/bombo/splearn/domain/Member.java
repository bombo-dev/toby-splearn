package com.bombo.splearn.domain;

import lombok.Builder;

public class Member {
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private MemberStatus status;

    @Builder
    private Member(Long id, String email, String nickname, String password, MemberStatus status) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.status = status;
    }

    public static Member create(Long id, String email, String nickname, String password) {
        return Member.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .status(MemberStatus.PENDING)
                .build();
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public MemberStatus getStatus() {
        return status;
    }
}
