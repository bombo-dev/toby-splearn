package com.bombo.splearn.application;

import com.bombo.splearn.application.provided.MemberRegister;
import com.bombo.splearn.application.required.EmailSender;
import com.bombo.splearn.application.required.MemberRepository;
import com.bombo.splearn.domain.EmailVo;
import com.bombo.splearn.domain.Member;
import com.bombo.splearn.domain.MemberCreateAction;
import com.bombo.splearn.domain.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberRegister {

    private final MemberRepository memberRepository;
    private final EmailSender emailSender;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberCreateAction createAction) {
        checkDuplicateEmail(createAction);

        Member member = Member.register(createAction, passwordEncoder);
        memberRepository.save(member);

        sendWelcomeEmail(member);

        return member;
    }

    private void sendWelcomeEmail(Member member) {
        emailSender.send(member.getEmail(), "등록을 완료해주세요", "아래 링크를 클릭해서 등록을 완료해주세요");
    }

    private void checkDuplicateEmail(MemberCreateAction createAction) {
        if (memberRepository.findByEmail(new EmailVo(createAction.email())).isPresent()) {
            throw new IllegalStateException("이미 사용중인 이메일입니다: " + createAction.email());
        }
    }
}
