package mySpringStudy.core.Order;

import mySpringStudy.core.discount.RateDiscountPolicy;
import mySpringStudy.core.member.Grade;
import mySpringStudy.core.member.Member;
import mySpringStudy.core.member.MemberRepository;
import mySpringStudy.core.member.MemoryMemberRepository;
import mySpringStudy.core.order.Order;
import mySpringStudy.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {
    
    @Test
    void createOrder() throws Exception {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}