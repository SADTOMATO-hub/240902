package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // => AOP가 적용가능한 Bean
public class EmpServiceImpl implements EmpService{
		//필드
	private EmpMapper empMapper;
	
		//생성자
	@Autowired
	EmpServiceImpl(EmpMapper empMapper){
		this.empMapper = empMapper;
	}//end EmpServiceImpl
	
		//메소드
	@Override
	public List<EmpVO> empList() {
		return empMapper.selectEmpAllList();
	}//end empList
	
	@Override
	public EmpVO empinfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}//end empinfo
	
	@Override
	public int empInsert(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO) ;
		
		return result == 1 ? empVO.getEmployeeId() : -1;
		//삼항연산자는 반드시 변수를 동반한다.
		//따라서 변수를 써야한다면 삼항연산자를 쓰도록 하자
				
	}//end empInsert
	
	@Override
	public Map<String, Object> empUpdate(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO.getEmployeeId(), empVO);
		
		if (result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		/*
		 {
		 	"result" : true,
		 	"target" : {
		 				 	employeeId : 100,
		 				 	lastName : "king",
		 				 	...
		 				}
		 }
		 */ //아작스 타입으로 반환
		return map;
	}//end empUpdate
	
	@Override
	public Map<String, Object> empDelete(int empId) {
		Map<String, Object> map = new HashMap<>();
		//삭제가 안 될 경우 : {} 아작스
		//삭제가 될 경우 : { "employeeId" : 104 }
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("employeeId", empId);
		}
		return map;
	}//end empDelete
	
}//end class
