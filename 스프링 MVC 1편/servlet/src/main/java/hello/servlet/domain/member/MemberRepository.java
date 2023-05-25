package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */

public class MemberRepository {
    // static 으로 생성하여서 new MemberRepository 여도 하나만 생성 될 것임.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // id

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤으로 할 것 임.
    // 아무나 생성할 수 없도록 private로 하였음.
    // 싱글톤이라 static 붙이지 않아도 됌. 한개인 것 보장해주어서.

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){

    }
    public Member save (Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); // store에 있는 모든 값 꺼내서 새로운 arrayList 로 만들어 줌.
        // 밖에서 조작해도 store 리스트를 건들고 싶지 않아서 이런식으로 함.
        // store의 값을 직접 가져와서 변경하면 변경이 됌.
        // store 자체 보호하기 위해 이런식으로 함.
    }

    public void clearStore(){
        store.clear();
    }
}
