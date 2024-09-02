package com.yedam.app.spring.xml;

public class JavaMainEX {
	public static void main(String[] args) {
		Chef cf = new Chef();
		Restaurant res = new Restaurant(cf);
		res.run();
	}
}
//기존 java의 방식 보시다시피 res 이전에 cf를 만들어 상속을 직접 시켜야 함