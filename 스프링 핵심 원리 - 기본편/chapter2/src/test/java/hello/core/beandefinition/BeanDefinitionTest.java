package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext gc = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // BeanDefinition 정보 꺼낼 수 있다.

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }

    @Test
    @DisplayName("xml 빈 설정 메타정보 확인")
    void findApplicationBeanXml(){
        String[] beanDefinitionNames = gc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = gc.getBeanDefinition(beanDefinitionName); // BeanDefinition 정보 꺼낼 수 있다.

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
        // xml로 했을 땐 bean에 대한 정보들이 다 나와있다.
        // 자바랑 차이는 bean의 클래스가 다 나와있다.
    }
}
