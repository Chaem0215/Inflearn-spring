package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * API 메시지 바디 - JSON
 */
@Getter
@Setter // Lombok 라이브러리
public class HelloData {

    private String userName;
    private int age;

}
