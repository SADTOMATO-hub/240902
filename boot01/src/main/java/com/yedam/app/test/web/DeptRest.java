package com.yedam.app.test.web;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.dept.service.DeptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeptRest {
	private final DeptService deptService;
	//삭제 - 처리
	@DeleteMapping("depts/{departmentId}")
	public Map<String, Object> deleteDept(@PathVariable Integer departmentId){
		return deptService.deleteDept(departmentId); 
		//우리는 페이지를 요하지 않기 때문에 REST를 쓰기는 하지만 그래도 데이터를 볼 수 있는 페이지가
		//필요하다는 사실을 잊지말자
	}
}