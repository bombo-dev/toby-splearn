package com.bombo.splearn.domain;

public class MemberFixture {

    public static MemberCreateAction defaultMemberCreateAction(String email) {
        return new MemberCreateAction(
            email,
            "password",
            "bombo"
        );
    }

    public static MemberCreateAction defaultMemberCreateAction() {
        return defaultMemberCreateAction("bombo@github.com");
    }
}
