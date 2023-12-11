package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import static org.assertj.core.api.Assertions.*;

public class SingletonTest
{
	
	@Test
	@DisplayName("스프링 없는 순수한 DI 컨테이너")
	void pureContainer()
	{
		AppConfig appConfig = new AppConfig();
		
		// 1. 조회 : 호출할 때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		
		// 2  조회 : 호출할 때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1); // memberService1 = hello.core.member.MemberServiceImpl@752325ad
		System.out.println("memberService2 = " + memberService2); // memberService2 = hello.core.member.MemberServiceImpl@279fedbd
		
		assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest()
	{
//		new SingletonService(); // error 발생
		
		SingletonService singletonService1 = SingletonService.getInstance();
		SingletonService singletonService2 = SingletonService.getInstance();
		
		// 같은 인스턴스 객체 반환
		System.out.println("singletonService1 = " + singletonService1);
		System.out.println("singletonService2 = " + singletonService2);
		
		assertThat(singletonService1).isSameAs(singletonService2); // isSameAs : == 비교, isEqualTo : equal() 비교
	}
	
	@Test
	@DisplayName("스프링 컨테이너와 싱글톤")
	void springContainer()
	{
		// 스프링 컨테이너는 싱글톤 패턴의 단점은 모두 해결하면서 객체를 싱글톤으로 유지할 수 있다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService1 = ac.getBean("memberService",MemberService.class);
		MemberService memberService2 = ac.getBean("memberService",MemberService.class);
		
		// 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1); // memberService1 = hello.core.member.MemberServiceImpl@2dd29a59
		System.out.println("memberService2 = " + memberService2); // memberService2 = hello.core.member.MemberServiceImpl@2dd29a59
		
		assertThat(memberService1).isSameAs(memberService2);
	}
}
