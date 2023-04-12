package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부에 private로 가짐, static이라 클래스 레벨에 올라가서 하나만 가짐 // 자바가 뜰 때 같이 생성된다.

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
