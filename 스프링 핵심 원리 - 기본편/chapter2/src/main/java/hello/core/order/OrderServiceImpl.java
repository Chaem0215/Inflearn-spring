package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final 이 붙은 것을 가지고 OrderServiceImpl 이 생성자를 만들어 준다.
public class OrderServiceImpl implements OrderService {
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // DIP 위반 인터페이스 뿐만아니라 구체화도 참조하여.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 추상화인 인터페이스에만 의존

    @Autowired // >> Lombok 을 사용하여 해당 생성자는 주석처리 해주었다.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice ){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //추상화인 인터페이스에만 의존하게되면 이부분 null값을 가져오게 된다.
        // DiscountPolicy의 구현 객체 생성후에 주입해야함

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
