package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
	// filed
	private Integer employeeId; // 사원아이디 : Primary key, not null
	private String firstName; // 사원 이름
	private String lastName; // 사원 성 : Not null
	private String email; // 사원 이메일 : Not null
	private String phoneNumber; // 사원 전번
	private Date hireDate; // 사원 고용일 : Not null
	private String jobId; // 사원 업무 번호 : Not null
	private Double salary; // 사원 급여 : Not null
	private Double commissionPct;// 사원 상여금
	private Integer managerId; // 사원 관리자 번호 : Foreign key : Not null
	private Integer departmentId;// 사원 부서 번호 : Foreign key : Not null
	// constructor

	// method

}
