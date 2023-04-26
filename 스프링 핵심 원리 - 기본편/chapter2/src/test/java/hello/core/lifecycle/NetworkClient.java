package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }
    public void setUrl(String url){ // 외부에서 넣을 수 있게,
        this.url = url;
    }
    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }
    public void call(String message){
        System.out.println("call : " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close" + url);
    }


    // 이 방법 선호 >> 빈 생명주기 콜백
    // Bean 등록이 아니라 컴포넌트 스캔이랑도 잘 어울림.
    // 외부 라이브러리에는 적용하지 못함. 필요시 @Bean에서 InitMethod 를 사용하면 됌.
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}


/*

섹션 8. 빈 생명주기 콜백

// 인터페이스 InitializingBean, DisposableBean 방식
public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }
    public void setUrl(String url){ // 외부에서 넣을 수 있게,
        this.url = url;
    }
    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }
    public void call(String message){
        System.out.println("call : " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close" + url);
    }

    // singleton Bean임
    // 의존관계 끝나면 afterPropertiesSet 이 호출됌.
    @Override
    public void afterPropertiesSet() throws Exception { // property 셋팅이 끝나면 (의존관계 주입 끝나면) 호출하겠다.
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception { // 종료될 때 호출이 됌.
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}


    // 2. 빈 등록 초기화, 소멸메서드 사용법
    // Bean에서 init과 close를 호출함
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
 */