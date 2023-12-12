package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		// 예제 안전하게 유지하기 위해서 @Configuration 애노테이션이 붙은 것들은 ComponentScan 제외하도록 ! (제대로 동작 검증을 확인하기 위해)
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // 자동으로 스캔해서 스프링 빈으로 설정해주는 애노테이션
public class AutoAppConfig
{

}
