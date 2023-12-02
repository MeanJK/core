package mySpringStudy.core;

import mySpringStudy.core.discount.DiscountPolicy;
import mySpringStudy.core.discount.FixDiscountPolicy;
import mySpringStudy.core.discount.RateDiscountPolicy;
import mySpringStudy.core.member.MemberRepository;
import mySpringStudy.core.member.MemberService;
import mySpringStudy.core.member.MemberServiceImpl;
import mySpringStudy.core.member.MemoryMemberRepository;
import mySpringStudy.core.order.OrderService;
import mySpringStudy.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); // 고정 할인 정책
        return new RateDiscountPolicy();  // 비율 할인 정책
    }

}
