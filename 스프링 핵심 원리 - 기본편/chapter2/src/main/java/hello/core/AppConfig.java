package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션의 환경구성은 AppConfig에서 다 할 것임.
// 실제 동작에 필요한 구현객체를 AppConfig에서 생성한다.
@Configuration // App의 구성정보를 담당한다는 설정 정보
public class AppConfig {
// 팩토리 메서드를 통해 등록하는 방식이다.
    // 팩토리 빈을 통해 적용되는 방식

    @Bean // 각 메서드에 적어줌 // 그럼 스프링 컨테이너에 등록이 된다.
    public MemberService memberService (){
        System.out.println("call AppConfig.memberService");
        return  new MemberServiceImpl(memberRepository()); // 생성자 주입
        // memberServiceImpl이고 memoryMemberRepo를 사용할 거라는 것.
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
       return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("all AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
