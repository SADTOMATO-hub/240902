package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	//필드
		private Integer departmentId;		//부서번호, 기본키
		private String departmentName;		//부서명,not null
		private Integer managerId;			//관리자 번호
		private Integer locationId;			//위치번호,fk
	//생성자
	//메소드
}
//1