package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 애플리케이션의 환경구성은 AppConfig에서 다 할 것임.
// 실제 동작에 필요한 구현객체를 AppConfig에서 생성한다.
public class AppConfig {
    public MemberService memberService (){
        return  new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
        // memberServiceImpl이고 memoryMemberRepo를 사용할 거라는 것.
    }
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
