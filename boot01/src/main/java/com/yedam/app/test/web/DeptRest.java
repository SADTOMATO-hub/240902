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
	}
}