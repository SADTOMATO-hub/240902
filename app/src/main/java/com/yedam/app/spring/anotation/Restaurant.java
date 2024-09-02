package com.yedam.app.spring.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //이 클레스를 빈에다가 등록
// 이렇게 등록해도 생성자 인젝션과 세터 인젝션을 쓸 수 있음
//@Autowired = 이 생성자를 기반으로 할것이다.
public class Restaurant {
	//필드
	private Chef chef;
	
	//생성자
	//생성자 인젝션 방식
	//@Autowired 
	Restaurant(Chef chef) {
		this.chef = chef;
		System.out.println("생성자 인젝션");
	}
	
	public Restaurant() {
		System.out.println("기본 생성자");
	}
	//세터 인젝션 반드시 기본 생성자가 있어야 한다.
	@Autowired 
	public void setChef(Chef chef) {
		this.chef = chef;
		System.out.println("세터 인젝션");
	}
	
	//메서드
	public void run() {
		chef.coocking();
	}
}
