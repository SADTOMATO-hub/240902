package com.yedam.app.spring.anotation;

import org.springframework.stereotype.Component;

@Component //이 클레스를 빈에다가 등록하겠다는 뜻
public class Chef {
	public void coocking() {
		System.out.println("Anotation 방식");
	}
}
