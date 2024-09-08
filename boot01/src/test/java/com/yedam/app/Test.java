package com.yedam.app;

import com.yedam.app.dept.service.DeptVO;

public class Test {
	
	public static void main(String[] args) {
		DeptVO deptVO = new DeptVO ();
		int id = deptVO.getDepartmentId();
		System.out.println(id);
	}
	
}
