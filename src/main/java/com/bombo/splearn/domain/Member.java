package com.bombo.splearn.domain;

import lombok.Builder;
import lombok.Getter;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.state;

@Getter
public class Member {
    private Long id;
    private EmailVo email;
    private String nickname;
    private String password;
    private MemberStatus status;

    @Builder
    private Member(Long id, String email, String nickname, String password, MemberStatus status) {
        this.id = id;
        this.email = new EmailVo(email);
        this.nickname = requireNonNull(nickname);
        this.password = requireNonNull(password);
        this.status = status;
    }

    public static Member create(Long id, String email, String nickname, String password, PasswordEncoder passwordEncoder) {
        return Member.builder()
                .id(id)
                .email(requireNonNull(email))
                .nickname(requireNonNull(nickname))
                .password(requireNonNull(passwordEncoder.encode(password)))
                .status(MemberStatus.PENDING)
                .build();
    }

    public void activate() {
        state(status == MemberStatus.PENDING, "PENDING 상태가 아닙니다");

        this.status = MemberStatus.ACTIVATE;
    }

    public void deactivate() {
        state(status == MemberStatus.ACTIVATE, "ACTIVE 상태가 아닙니다");

        this.status = MemberStatus.DEACTIVATED;
    }

    public boolean verifyPassword(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, this.password);
    }

    public void changeNickname(String nickname) {
        this.nickname = requireNonNull(nickname);
    }

    public void changePassword(String password, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(requireNonNull(password));
    }

    public boolean isActivate() {
        return this.status == MemberStatus.ACTIVATE;
    }
}
