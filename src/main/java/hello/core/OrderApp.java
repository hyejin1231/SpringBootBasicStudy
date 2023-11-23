package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp
{
	public static void main(String[] args)
	{
		// V1. 관심사 분리 이전
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
		
		// V2. 관심사 분리 이후
		AppConfig appConfig = new AppConfig();
		MemberService memberService = appConfig.memberService();
		OrderService orderService = appConfig.orderService();
		
		Long memberId= 1L;
		Member member = new Member(memberId, "hyejin", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order);
		System.out.println("order.calculatorPrice() = " + order.calculatorPrice());
	}
}
