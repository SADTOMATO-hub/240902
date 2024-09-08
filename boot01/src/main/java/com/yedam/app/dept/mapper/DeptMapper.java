package com.yedam.app.dept.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	//전체조회
	public List<DeptVO> selectDeptAll();
	//단건조회
	public DeptVO selectDept(int departmentId);
	//등록
	public int insertDept (DeptVO deptVO);
	//수정
	//삭제
	public int deleteDept (int departmentId);
}
//2