package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 컴포넌트 스캔은 자동으로 스프링빈을 끌어와야한다.
@ComponentScan( // @Component 가 붙은 애를 가져와서 스캔함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //  @ComponentScan.Filter 에서 설정한 애들은 컴포넌트 스캔에서 제외 >> Configuration 이 애노테이션이 붙은 애들은 뺄것임 (수동등록)
public class AutoAppConfig {

}
