package hello.core.order;

import hello.core.discont.DiscountPolicy;
import hello.core.discont.FixDiscountPolicy;
import hello.core.discont.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService
{
	// V1. 관심사 분리 전
//	private final MemberRepository memberRepository = new MemoryMemberRepository();
	
	// DIP 위반 ! 추상과 구체화 모두 의존 중이기 때문
	// OCP 위반 ! FixDiscountPolicy에서 RateDiscountPolicy로 변경하려는 순간 클라이언트 코드도 변경해야 하기 때문 !
//	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	
	// V2. 관심사 분리 후 -> 생성자를 통해 주입
	// DIP, OCP를 잘 지키고 있다.
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	public OrderServiceImpl(MemberRepository memberRepository,
			DiscountPolicy discountPolicy)
	{
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}
	
	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice)
	{
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
	// 테스트 용도
	public MemberRepository getMemberRepository()
	{
		return memberRepository;
	}
}
