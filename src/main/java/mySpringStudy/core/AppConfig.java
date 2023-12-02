package mySpringStudy.core;

import mySpringStudy.core.discount.DiscountPolicy;
import mySpringStudy.core.discount.FixDiscountPolicy;
import mySpringStudy.core.member.MemberRepository;
import mySpringStudy.core.member.MemberService;
import mySpringStudy.core.member.MemberServiceImpl;
import mySpringStudy.core.member.MemoryMemberRepository;
import mySpringStudy.core.order.OrderService;
import mySpringStudy.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
