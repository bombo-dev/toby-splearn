package com.bombo.splearn.application.required;

import com.bombo.splearn.domain.EmailVo;
import com.bombo.splearn.domain.Member;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {
    Member save(Member member);

    Optional<Member> findByEmail(EmailVo email);
}
