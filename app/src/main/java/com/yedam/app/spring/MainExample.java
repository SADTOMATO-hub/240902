package com.yedam.app.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {

	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml"); //컨테이너를 생성하는 클래스 
		//fil.src/main/resources/applicationContext.xml에 등록된 
		TV tv =
		(TV)/*bean 같은 경우는 리턴 값을 객체로 갖기 때문에 강제로 형변환을 해야 함*/ ctx.getBean("tv");  //getbean은 등록된 id를 매개로 빈을 호출하는 기능
		tv.turnOn();
		
		TV subTv = ctx.getBean(TV.class); //클래스 파일이 가진 정보 자체를 넘기는 기능
		subTv.turnOn();
		
		if(tv == subTv) {// 기본적으로 컨테이너에 등록된 빈들은 싱글톤이다.
			System.out.println("같은 빈입니다.");
		}else {
			System.out.println("다른 빈입니다.");
		}//end if
	}//end main
}//end class
//spring 방식
