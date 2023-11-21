package hello.core.member;

public interface MemberService
{
	/**
	 * 회원 가입
	 * @param member
	 */
	void join(Member member);
	
	/**
	 * 회원 조회
	 * @param memberId
	 */
	Member findMember(Long memberId);
}
