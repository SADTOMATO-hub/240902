package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//전체조회
	public List<EmpVO> selectEmpAllList();
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	//등록
	public int insertEmpInfo(EmpVO empVO); 
	//수정
	public int updateEmpInfo(@Param("empid") int empId, 
							 @Param("emp") EmpVO empVO); // 아이디를 기준으로 수정하기 때문에, 내부적으로 조인을 하거나 할 경우와 같이 처리해야 할 게 있어서 뭘 수정할지 모르기 때문에 VO
	//삭제											 
	public int deleteEmpInfo(int empId); 			  // 아이디를 기준으로 삭제하기 때문에
}
//인터페이스는 bean을 등록할 수 없다.
//이 인터페이스의 경로는 어플리케이션 프로퍼티의 20번째 줄
//@Param = 들어는 파라메터를 구분하는 역할