package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // ApplicationContext : 스프링은 이걸로 시작, 이게 스프링 컨테이너이다. 모든걸 관리해준다 객체를
        // @Bean은 생성한 객체를 스프링컨테이너에 집어넣어서 관리해줌.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 객체 찾아서 (2번째는 타입) memberService에 넣겠다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
