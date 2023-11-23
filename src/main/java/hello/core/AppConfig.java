package hello.core;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig
{
	public MemberService memberService()
	{
		return new MemberServiceImpl(MemberRepository());
	}
	
	private MemoryMemberRepository MemberRepository()
	{
		return new MemoryMemberRepository();
	}
	
	public OrderService orderService()
	{
		return new OrderServiceImpl(MemberRepository(), discountPolicy());
	}
	
	// 새로운 할인 정책 적용 !
	// 클라이언트 코드 (OrderServiceImpl은 수정할 필요 없이, AppConfig만 수정해주면 된다!!)
	public DiscountPolicy discountPolicy()
	{
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
	
}
