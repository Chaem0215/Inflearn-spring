package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // 스프링 빈이 올라올 때 Autowired 가 호출이 됌.
    static class TestBean{
        @Autowired(required = false) // required 기본이 true // 여기서 required가 true라면 예외터짐 // Member가 스프링 빈이 아니라서.
        public void setNoBean1(Member noBean1){ // Member는 스프링빈이 관리하는 것이 없다.
            System.out.println("noBean1 = " + noBean1);
        } // 이거 자체가 호출이 안됌. 의존관계가 없으면 이 메서드가 호출이 안된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ // null 이면 default 가 나온다 라는 것. 호출은 되지만.
            System.out.println("noBean1 = " + noBean2);
        }
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3){ // java 8 에서 사용중인 Optional
            System.out.println("noBean3 = " + noBean3); // 스프링 빈이 없으면 Optional.empty가 나온다. 값이 있으면 Optional으로 감싸짐.
        }

        // Nullable, Optional 은 스프링 전반에 걸쳐 지원 됌.
    }
}
