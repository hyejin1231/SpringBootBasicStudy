package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
//		V1. 관심사 분리 이전
//		MemberService memberService = new MemberServiceImpl();

//		V2. 관심사 분리 이후
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();

//		V3. 스프링으로 전환하기
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		
		memberService.join(new Member(1L, "hyejin", Grade.VIP));
		Member findMember = memberService.findMember(1L);
		
		
		System.out.println("findMember = " + findMember.getName());
	}
}
