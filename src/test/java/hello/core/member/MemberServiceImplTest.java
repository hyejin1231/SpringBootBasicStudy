package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceImplTest
{
//	 V1. 관심사 분리 이전
//	MemberService memberService = new MemberServiceImpl();
	
	//	V2. 관심사 분리 이후
	MemberService memberService;
	
	@BeforeEach
	public void beforeEach()
	{
		AppConfig appConfig = new AppConfig();
		memberService= appConfig.memberService();
	}
	
	@Test
	void join()
	{
		//given
		Member member = new Member(1L, "hyejin", Grade.VIP);
		
		// when
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		
		// then
		Assertions.assertThat(member).isEqualTo(findMember);
		
	}
}