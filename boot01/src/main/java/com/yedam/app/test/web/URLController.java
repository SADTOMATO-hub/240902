package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //Bean등록, web과 관련된 부분 담당
public class URLController {
	//@RequestMapping(path="/test", method=RequestMethod.GET) //컨트롤러의 이름 = test // 방식 = GET 방식 // RequestMapping 권장치 않음 
	@GetMapping("/test")
	@ResponseBody // =>순수하게 데이터만 반영,  AJAX용
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n select -" + keyword;	
	}
	
	
	
	//@RequestMapping(path="/test", method=RequestMethod.POST) //컨트롤러의 이름 = test // 방식 = POST 방식 // RequestMapping 권장치 않음     
	@PostMapping("/test")
	@ResponseBody // =>순수하게 데이터만 반영,  AJAX용
	public String urlPostTest(String keyword) {
		return "Server Response : Post Method\n select -" + keyword;	
	}
}
//컨트롤러 어노테이션 테스트 GET과 POST