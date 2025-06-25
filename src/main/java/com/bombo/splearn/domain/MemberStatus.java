package com.bombo.splearn.domain;

import lombok.Getter;

@Getter
public enum MemberStatus {
    PENDING("가입 대기"),
    ACTIVATE("가입 완료"),
    DEACTIVATED("회원 탈퇴");

    private final String description;

    MemberStatus(String description) {
        this.description = description;
    }
}

