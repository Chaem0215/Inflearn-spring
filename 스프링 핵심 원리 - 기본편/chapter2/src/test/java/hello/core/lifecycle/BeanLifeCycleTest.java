package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{

        // 2. 빈 등록 초기화, 소멸 메서드 사용법 (NetworkClient에 해당 메서드 존재함.)
        //@Bean(initMethod = "init") // , destroyMethod = "close" 생략해도 동작이 됌. 추론이 일어남. close 나 shutdown 의 이름을 가진 메서드를 추론해서 띄움.
        @Bean
        public NetworkClient networkClient(){
            System.out.println("LifeCycleConfig.networkClient");
            NetworkClient networkClient = new NetworkClient(); // 객체 다 생성함.
            networkClient.setUrl("http://naver.com");
            return networkClient;
        }
    }
}
