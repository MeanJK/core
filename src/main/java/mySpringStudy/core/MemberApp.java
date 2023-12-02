package mySpringStudy.core;

import mySpringStudy.core.member.Grade;
import mySpringStudy.core.member.Member;
import mySpringStudy.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("MemberService", MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        
        System.out.println("new member=" + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
