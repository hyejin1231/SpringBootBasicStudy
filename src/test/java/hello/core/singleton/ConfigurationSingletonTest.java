package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import static org.assertj.core.api.Assertions.*;

// @Configuration 과 싱글톤
public class ConfigurationSingletonTest
{
	@Test
	void configurationTest()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean(MemberRepository.class);
		
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		
		// 다 같은 memberRepository 인스턴스 객체임을 알 수 있다.
		System.out.println("memberService -> memberRepository1 = " + memberRepository1);
		System.out.println("orderService -> memberRepository2 = " + memberRepository2);
		System.out.println("memberRepository = " + memberRepository);
		
		assertThat(memberRepository1).isSameAs(memberRepository2);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
		
	}
	
	@Test
	void configurationDeep()
	{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("bean.getClass() = " + bean.getClass()); // bean.getClass() = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$d05c737
	}
}
