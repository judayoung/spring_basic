package hello.core;

import hello.core.member.Member;
import hello.core.member.Grade;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        //AppConfig appConfig=new AppConfig();
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        //MemberService memberService = appConfig.memberService();
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //OrderService orderService = appConfig.orderService();
        OrderService orderService = ac.getBean("orderService", OrderService.class);
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId=1L;
        Long memberId2=2L;
        Member member=new Member(memberId,"memberA", Grade.VIP);
        Member member2=new Member(memberId2,"memberA", Grade.BASIC);
        memberService.join(member);
        memberService.join(member2);

        Order order= orderService.createOrder(memberId, "itemA",20000);
        Order order2= orderService.createOrder(memberId2, "itemA",10000);

        System.out.println("order = "+order.toString());
        System.out.println("order.calculatePrice = "+order.calculatePrice());
        System.out.println("order2 = "+order2.toString());
        System.out.println("order2.calculatePrice = "+order2.calculatePrice());
    }
}
