package com.yedam.app.web.config;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebAdvice {
	// @ControllerAdvice의 역할 = 예외처리, 공통된 변수 선언
	// 예외처리, 웹에서의 흐름은 시작과 끝이 불명확하기 때문에 이 친구로 처리한다. try/catch는 정해진 코드 내의 예외만 처리한다.
	//@ExceptionHandler(IllegalAccessException.class)
	//public ResponseEntity<String> invokeError(IllegalAccessException error) {
	//	return new ResponseEntity<>("Error Messege", HttpStatus.BAD_REQUEST);
	//}

	// 공통변수선언
	@ModelAttribute("ContextPath")
	public String contextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	@ExceptionHandler(SQLException.class) //SQL에서 오류가 발생하면 이 예외처리를 실행함
	public ResponseEntity<String> invokeError(SQLException error) {
		return new ResponseEntity<>("Error Messege", HttpStatus.BAD_REQUEST);
	}
}// end class
