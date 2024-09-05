package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")//인터페이스를 읽어 들이는 작업,
													//특정을 포멧을 지정하고 그 경로의 모든 인터페이스를 읽음 , 
												    //** = 메퍼의 기능을 구분하는 역할
public class Boot01Application {
	public static void main(String[] args) {
		SpringApplication.run(Boot01Application.class, args);
	}

}
