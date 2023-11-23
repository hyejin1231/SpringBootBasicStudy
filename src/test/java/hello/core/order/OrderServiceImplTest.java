package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest
{
	// V1. 관심사의 분리 이전
	// MemberService memberService = new MemberServiceImpl();
	// OrderService orderService = new OrderServiceImpl();
	
	// V2. 관심사 분리 이후
	MemberService memberService;
	
	OrderService orderService;
	@BeforeEach
	public void beforeEach()
	{
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	@Test
	void createOrder()
	{
		Long memberId = 1L;
		Member member = new Member(memberId, "hyejin", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}