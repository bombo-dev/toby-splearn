package com.bombo.splearn.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.Assert.state;

@Entity
@NaturalIdCache
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Embedded
    private EmailVo email;

    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Builder
    private Member(Long id, String email, String nickname, String password, MemberStatus status) {
        this.id = id;
        this.email = new EmailVo(email);
        this.nickname = requireNonNull(nickname);
        this.password = requireNonNull(password);
        this.status = status;
    }

    public static Member register(MemberCreateAction action, PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(requireNonNull(action.email()))
                .nickname(requireNonNull(action.nickname()))
                .password(requireNonNull(passwordEncoder.encode(action.password())))
                .status(MemberStatus.PENDING)
                .build();
    }

    public void activate() {
        state(status == MemberStatus.PENDING, "PENDING 상태가 아닙니다");

        this.status = MemberStatus.ACTIVATE;
    }

    public void deactivate() {
        state(status == MemberStatus.ACTIVATE, "ACTIVATED 상태가 아닙니다");

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
