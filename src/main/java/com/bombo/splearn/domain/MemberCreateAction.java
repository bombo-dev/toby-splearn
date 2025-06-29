package com.bombo.splearn.domain;

public record MemberCreateAction(
    String email,
    String password,
    String nickname
) {
}
