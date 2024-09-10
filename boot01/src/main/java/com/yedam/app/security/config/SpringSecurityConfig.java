package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration // 내부의 메소드 결과를 bean에 등록하는 어노테이션
public class SpringSecurityConfig {
	@Bean //비밀번호 암호화, 암호화는 가능하지만 복구는 불가능
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean // 메모리상 인증정보 등록 => 테스트 전용
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails user //spring security가 사용하는 VO같은 개념
		  = User.builder() //생성자를 요구하지 않음, 매개 변수를 사용하면 매개 변수의 타입에 맞춰 값을 입력 받지만, 이 형태는 정확하게 원하는 위치에 값을 넣을 수 있다
				.username("user1")
				.password(passwordEncoder().encode("1234"))
				.roles("USER") // ROLE_USER --> 강제로 ROLE을 붙여 버리는 메소드
				//.authorities("ROLE_USER") --> 이것 자체가 입력된 값을 권한 취급하는 메소드
				.build();
		
		UserDetails admin //spring security가 사용하는 VO같은 개념
		  = User.builder() //생성자를 요구하지 않음, 매개 변수를 사용하면 매개 변수의 타입에 맞춰 값을 입력 받지만, 이 형태는 정확하게 원하는 위치에 값을 넣을 수 있다
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				//.roles("ADMIN") // ROLE_USER --> 강제로 ROLE을 붙여 버리는 메소드
				.authorities("ROLE_ADMIN","ROLE_USER") //--> 이것 자체가 입력된 값을 권한 취급하는 메소드, admin에게도 user의 권한을 부여했음
				.build();
		return new InMemoryUserDetailsManager(user,admin);
	}
	*/
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//적용될 security 설정
		// URI에 적용될 권한
		http
			.authorizeHttpRequests(authrize 
					-> authrize
					.requestMatchers("/", "/all").permitAll() //모든 권한을 허용, 인증조차 받지 않음, 메인페이지에서 쓰기 참 좋음
					.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")//강제로 ROLE_를 붙임. 이 친구가 더 약함. LIKE 일반 사원	
					.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") //admin이외엔 권한이 없음. 이 친구가 더 강함 LIKE 대표
					.anyRequest().authenticated()             //any~와 auth~는 세트로 움직이며 위의 것들을 빼고 나머지들을 일괄처리, 
														      //authenticated() = 인증여부만 체크
					)
					.formLogin(formlogin -> formlogin         //명시하지 않으면 로그인 창이 안 뜸.
							.defaultSuccessUrl("/all"))			
					.logout(logout -> logout
							.logoutSuccessUrl("/all").invalidateHttpSession(true));       //커스터마이징을 하라는 의미
		
		http.csrf(csrf -> csrf.disable()); //<-- 보안을 강제로 끄는 기능
		
		return http.build();
	}
}