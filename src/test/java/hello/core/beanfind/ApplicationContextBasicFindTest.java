package hello.core.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest
{
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName()
	{
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService = " + memberService);
		System.out.println("memberService.getClass() = " + memberService.getClass());
		
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("이름없이 타입으로 조회")
	void findBeanByType()
	{
		MemberService memberService = ac.getBean(MemberService.class); // 타입으로만 조회도 가능
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2()
	{
		MemberService memberService = ac.getBean( "memberService", MemberServiceImpl.class); // 구현에 의존하는 건 좋지 않음 (유연성이 떨어짐)
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByNameX()
	{
//		ac.getBean("xxxx", MemberService.class);
		
		Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
			MemberService xxxx = ac.getBean("xxxx", MemberService.class);
		});
	}
	
	
}
