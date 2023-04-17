package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent { // 얘가 붙은 것은 ComponentScan 에 제외 할 것이다. 라고 생각하면 됌
    
}
