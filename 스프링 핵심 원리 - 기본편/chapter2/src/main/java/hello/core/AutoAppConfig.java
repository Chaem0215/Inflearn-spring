package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 컴포넌트 스캔은 자동으로 스프링빈을 끌어와야한다.
@ComponentScan( // @Component 가 붙은 애를 가져와서 스캔함
        basePackages = "hello.core", // hello.core.member 는 member 패키지부터 하위로 찾아가는거, member 만 대상이 되는 것이다.
        // 이거 없으면 모든 자바코드 다 뒤져서 시간이 오래걸림. {"hello.core", "hello.service"} 이렇게 여러개 가능
        // basePackageClasses = AutoAppConfig.class, // package hello.core; 부터 찾는 것임 (AutoAppConfig 의 패키지)

        // 위의 basePackages 를 지정하지 않으면?
        // @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작위치가 된다.
        // 권장 방법 : 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것 (스프링 부트에도 이게 기본 제공)
        // 이 프로젝트에서는 hello.core 가 최상단 >> 여기에 ComponentScan 만 붙이면 됌.

        // 스프링 부트는 ComponentScan 으로 기본적으로 돌아간다.
        // 스프링 부트를 쓰면 hello.core 여기서부터 ComponentScan 을 하겠다는 것임. 그래서 자동으로 스프링빈에 등록함.

        // 애노테이션은 상속관계가 없다. 연동 되는 것도 없음.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //  @ComponentScan.Filter 에서 설정한 애들은 컴포넌트 스캔에서 제외 >> Configuration 이 애노테이션이 붙은 애들은 뺄것임 (수동등록)
public class AutoAppConfig {
    //@Bean(name = "memoryMemberRepository")
    //MemberRepository memberRepository(){
    //    return new MemoryMemberRepository();
    //}
}
