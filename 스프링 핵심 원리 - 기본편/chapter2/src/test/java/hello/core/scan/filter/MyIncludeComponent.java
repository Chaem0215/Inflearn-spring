package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent { // 얘가 붙은 것은 ComponentScan 에 추가 할 것이다. 라고 생각하면 됌 
    
}
