package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 *  Junit 을 사용하지 않은 테스트 코드,, -> 테스트 코드를 작성하자.
 */
public class MemberApp
{
	public static void main(String[] args)
	{
		MemberService memberService = new MemberServiceImpl();
		memberService.join(new Member(1L, "hyejin", Grade.VIP));
		
		Member findMember = memberService.findMember(1L);
		System.out.println("findMember = " + findMember.getName());
	}
}
