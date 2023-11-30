package mySpringStudy.core;

import mySpringStudy.core.member.Grade;
import mySpringStudy.core.member.Member;
import mySpringStudy.core.member.MemberService;
import mySpringStudy.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        
        System.out.println("new member=" + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
