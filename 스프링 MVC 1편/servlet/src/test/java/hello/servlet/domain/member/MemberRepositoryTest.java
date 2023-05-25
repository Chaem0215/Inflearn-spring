package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance(); // 싱글톤이라 new 안 씀.

    @AfterEach // Test 끝나면 초기화 해주려고 사용
    void afterEach(){
        memberRepository.clearStore();
    } // Test는 순서 보장이 안된다. 그래서 clear 해줌

    @Test
    void save(){
        // given 주어졌을때
        Member member = new Member("hello", 20);

        // when 실행했을때
        Member savedMember = memberRepository.save(member);

        // then 이런 결과
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}