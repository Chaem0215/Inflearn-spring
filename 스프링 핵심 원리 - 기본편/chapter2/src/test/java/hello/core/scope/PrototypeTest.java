package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototype Bean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototype Bean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        //prototypeBean1.destroy(); // 직접 수 작업을 해줘야함. // 조회한 클라이언트가 직접 종료 해야함.
        ac.close();
    }
    /*
    find prototype Bean1
    SingletonBean.init // 조회할 때 생성
    find prototype Bean2
    SingletonBean.init
    prototypeBean1 = hello.core.scope.PrototypeTest$PrototypeBean@673fdbce
    prototypeBean2 = hello.core.scope.PrototypeTest$PrototypeBean@5965d37
     */ //close 가 안된건 프로토타입은 쓰다 버려서.


    // new AnnotationConfigApplicationContext(PrototypeBean.class);
    // 여기에 PrototypeBean.class 를 등록하면 컴포넌트 스캔 대상처럼 동작해서 @컴포넌트 해주지 않아도 됌.
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }
}
