package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	//전체조회
	public List<DeptVO> deptList();
	//단건조회
	public DeptVO deptInfo(int departmentId);
	//등록
	public int insetInfo(DeptVO deptVO) ;
	//수정
	//삭제
	public Map<String, Object> deleteDept(int departmentId);
}
//4