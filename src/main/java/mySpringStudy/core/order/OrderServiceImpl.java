package mySpringStudy.core.order;

import mySpringStudy.core.discount.DiscountPolicy;
import mySpringStudy.core.discount.FixDiscountPolicy;
import mySpringStudy.core.member.Member;
import mySpringStudy.core.member.MemberRepository;
import mySpringStudy.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
