package hello.core.singleton;

// 싱글톤 패턴
public class SingletonService
{
	// 1. static 영역에 객체 instance 를 미리 하나 생성해서 올려둔다.
	private static final SingletonService instance = new SingletonService();
	
	// 2. 해당 인스턴스가 필요하면 getInstance() 메서드를 통해서만 조회할 수 있다.
	public static SingletonService getInstance()
	{
		return instance;
	}
	
	// 3. 딱 한개의 인스턴스만 존재해야하기 때문에 생성자를 private로 막아서 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막아야 한다.
	private SingletonService()
	{
		// 외부에서 생성할 수 없도록 private로 선언
	}
	
	public void logic()
	{
		System.out.println("싱글톤 객체 로직 호출 !! ");
	}
}
