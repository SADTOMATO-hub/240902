package com.yedam.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.AOP.service.AaaService;

@SpringBootTest
public class AopTest {
	@Autowired
	AaaService aaaService;
	
	@Test
	void ttt() {
		aaaService.insert();
	}
}
//4