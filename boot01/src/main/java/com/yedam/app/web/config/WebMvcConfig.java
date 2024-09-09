package com.yedam.app.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration 
//구현 클레스
public class WebMvcConfig implements WebMvcConfigurer/*실행 블록이 없어서 오버라이드를 요구하지 않음*/ {
	@Value("${file.upload.path}")//환경변수 및 properties 파일의 변수 값을 , 메모리에 등록된 변수값을 호출하는 것
	private String uploadpath;
	//리소스 핸들링
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry
		.addResourceHandler("/imgs/**") //접근하고자 하는 URL을 결정하는 것, 저 아스타가 중요함
		.addResourceLocations("file:///" + uploadpath); // 실제 물리적인 경로
	}
	
}
