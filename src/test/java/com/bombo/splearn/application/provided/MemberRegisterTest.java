package com.bombo.splearn.application.provided;

import com.bombo.splearn.domain.Member;
import com.bombo.splearn.domain.MemberFixture;
import com.bombo.splearn.domain.MemberStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class MemberRegisterTest {

    @Autowired
    private MemberRegister memberRegister;

    @Test
    void register() {
        Member member = memberRegister.register(MemberFixture.defaultMemberCreateAction());

        assertThat(member.getId()).isNotNull();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void duplicateEmailFail() {
        Member member = memberRegister.register(MemberFixture.defaultMemberCreateAction());

        assertThatThrownBy(() -> memberRegister.register(MemberFixture.defaultMemberCreateAction()))
                .isInstanceOf(IllegalStateException.class);

    }
}