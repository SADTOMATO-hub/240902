package com.yedam.app.spring.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Component
public class JavaConfig {
	@Bean //반환한 대상을 그대로 빈에다가 등록하겠다는 뜻
	public Chef chef() {
		return new Chef();
	}
	@Bean 
	//xml을 쓰지 말고 자바로 하자
	public Restaurant restaurant(Chef chef) {
		//return new Restaurant(chef); //생성자 주입 방식
		Restaurant res = new Restaurant();
		res.setChef(chef);
		return res; //세터 주입 방식
	}
	
	
}
