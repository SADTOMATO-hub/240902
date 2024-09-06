package com.yedam.app.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yedam.app.emp.service.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Aspect // aop의 설정
@Component //
//@Configuration 클래스 내의 함수의 반환 값을 등록하는 기능 (1회용)
@Slf4j // lombok 스프링에서 로그를 찍는 법
public class CommonAspect {
	//포인트컷 : 조인포인트(@Service의 메소드들)중에서
	//        Advice(횡단관심, 부가기능)이 적용될 메소드 조건
	@Pointcut("within(com.yedam.app.emp.service.impl.*)") //모든 서비스가 작동할 때 공통적으로 적용되어야 하는 걸 적용시키는 걸 AOP가 한다.
	public void empPointCut() {
	//	log.debug("aop");
	}
	
	//Weaving : 포인트컷 + 동작시점 + Advice
	@Before("empPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		String singerStr = joinPoint.getSignature().toString();
		Object[] args = joinPoint.getArgs();
		log.error("####### 실행 : " + singerStr);
		for(Object arg : args) {
			log.error("매개변수", arg);
			if(arg instanceof Integer) {
				System.err.println((Integer)arg);
			}else if(arg instanceof EmpVO){
				System.err.println((EmpVO)arg);
			}
		}
	}//end beforeAdvice
	
	@Around("empPointCut()")
	public Object executeTime(ProceedingJoinPoint joinPoint) throws Throwable {
		String love
			= joinPoint.getSignature().toString();
		System.out.println("== 시작 : " + love);
		//공통기능
		System.out.println("핵심 기능 전 실행 : " + System.currentTimeMillis());
		try {
			//비즈니스 메소드
			Object obj = joinPoint.proceed();
			return obj;
		}finally {
			//공통기능
			System.out.println("핵심 기능 후 실행 : " + System.currentTimeMillis());
			System.out.println("=== 끝 :" + love);
		}
	}
}
