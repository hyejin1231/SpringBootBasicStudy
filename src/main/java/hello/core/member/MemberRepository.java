package hello.core.member;

public interface MemberRepository
{
	/**
	 * 회원 가입
	 * @param member
	 */
	void save(Member member);
	
	/**
	 * 회원 조회
	 * @param memberId
	 * @return
	 */
	Member findById(Long memberId);
}
