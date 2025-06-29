package com.bombo.splearn.application.provided;

import com.bombo.splearn.domain.Member;
import com.bombo.splearn.domain.MemberCreateAction;

public interface MemberRegister {
    Member register(MemberCreateAction action);
}
