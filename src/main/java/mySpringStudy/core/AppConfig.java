package mySpringStudy.core;

import mySpringStudy.core.discount.FixDiscountPolicy;
import mySpringStudy.core.member.MemberService;
import mySpringStudy.core.member.MemberServiceImpl;
import mySpringStudy.core.member.MemoryMemberRepository;
import mySpringStudy.core.order.OrderService;
import mySpringStudy.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
