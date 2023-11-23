package hello.core.member;

public class MemberServiceImpl implements MemberService
{
	// V1. 관심사 분리 전
	// OCP, DIP 원칙을 지키지 않고 있다.
	// OCP -> MemoryMemberRepository에서 DbMemberRepository로 변경하고자 하면 클라이언트가 직접 코드를 변경해야 함.
	// DIP -> 인터페이스만 의존해야하는데, 구현 클래스에도 의존하고 있음.
	// private MemberRepository memberRepository = new MemoryMemberRepository();
	
	// V2. 관심사 분리 후
	// 생성자를 통해서 MemberRepository에 무엇이 들어갈지 결정 (생성자 주입)
	// MemberRepository에만 의존 가능 !! (구체화엔 의존 x)
	private final MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository memberRepository)
	{
		this.memberRepository = memberRepository;
	}
	
	@Override
	public void join(Member member)
	{
		memberRepository.save(member);
	}
	
	@Override
	public Member findMember(Long memberId)
	{
		return memberRepository.findById(memberId);
	}
}
