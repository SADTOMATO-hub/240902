package com.yedam.app.spring.xml;

public class Restaurant {
	//필드
	private Chef chef;
	
	//생성자 인젝션 방식
	Restaurant(Chef chef) {
		this.chef = chef;
		System.out.println("생성자 인젝션");
	}
	
	public Restaurant() {
		System.out.println("기본 생성자");
	}
	//세터 인젝션 반드시 기본 생성자가 있어야 한다.
	public void setChef(Chef chef) {
		this.chef = chef;
		System.out.println("세터 인젝션");
	}
	//메서드
	public void run() {
		chef.coocking();
	}
}
