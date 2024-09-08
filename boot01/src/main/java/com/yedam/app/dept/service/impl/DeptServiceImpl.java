package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service 
public class DeptServiceImpl implements DeptService{
	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper){
		this.deptMapper = deptMapper;
	}
	
	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectDeptAll();
	}
	
	@Override
	public DeptVO deptInfo(int departmentId) {
		return deptMapper.selectDept(departmentId);
	}
	@Override
	public int insetInfo(DeptVO deptVO) {
		int result = deptMapper.insertDept(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}
	@Override
	public Map<String, Object> deleteDept(int departmentId) {
		Map<String, Object> map = new HashMap<>();
		 int result = deptMapper.deleteDept(departmentId);
		if (result == 1) {
			map.put("departmentId", departmentId);
		}
		return map;
	}
}
//5
