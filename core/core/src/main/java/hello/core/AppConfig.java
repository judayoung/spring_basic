  package hello.core;

  import hello.core.discount.DiscountPolicy;
  import hello.core.discount.RateDiscountPolicy;
  import hello.core.member.MemberService;
  import hello.core.member.MemberServiceImpl;
  import hello.core.member.MemoryMemberRepository;
  import hello.core.order.OrderService;
  import hello.core.order.OrderServiceImpl;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean(name="mmm")
    @Bean
    public MemberService memberService(){
        //공연기획자 : AppConfig
        // AppConfig는
        // MemberService의 구현체로 MemberServiceImpl을 선택하며
        // 선택과 동시에 MemberRepository의 구현체로
        // MemoryMemberRepository를 선택한다.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
