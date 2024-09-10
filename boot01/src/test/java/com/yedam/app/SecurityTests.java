package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTests {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void pwdEncoderTest() {
		String password = "1234";
		
		String enPwd = passwordEncoder.encode(password);
		System.out.println(enPwd);
		
		boolean result = passwordEncoder.matches(password, enPwd);
		System.out.println(result); 
		//정해진 알고리즘으로 작동하기 때문에, 이걸 다시 실행한다 해도 전에 쓰던 게 사라지지는 않음
	}
}
