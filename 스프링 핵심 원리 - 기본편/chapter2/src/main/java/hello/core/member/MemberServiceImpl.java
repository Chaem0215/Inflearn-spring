package hello.core.member;

public class MemberServiceImpl implements MemberService {
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository; // 추상화에만 의존


    public void join(Member member){
        memberRepository.save(member);
    }
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}
