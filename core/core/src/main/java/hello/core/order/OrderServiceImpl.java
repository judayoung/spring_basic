package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    //할인 정책 변경.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private DiscountPolicy discountPolicy; //인터페이스에만 의존하도록 코드 변경.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    //1. 클라이언트가 주문생성을 요구
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //2. 저장소에서 회원검색
        Member member=memberRepository.findById(memberId);
        //3. 할인정책에서 할인금액 가져오기
        int discountPrice= discountPolicy.discount(member,itemPrice);

        //4. 클라이언트에게 주문 결과를 반환.
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
