package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper") //어플리케이션 프로퍼타이즈 13번째 줄
public class BootBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBoardApplication.class, args);
	}

}
