package com.yedam.app.spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml"); //컨테이너를 생성하는 클래스 
		//file.src/main/resources/applicationContext.xml에 등록된 
		
		Restaurant res = (Restaurant) ctx.getBean(Restaurant.class);
		res.run();  //chef가 없는데도 실행되는 이유?? 우리가 applicationContext.xml에 상속 작업을 마쳤기 때문
	}
}
//DI의 방식