package com.yedam.app.AOP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.AOP.mapper.AaaMapper;

@Service
public class AaaServiceImpl implements AaaService{
	private AaaMapper aaaMapper;
	@Autowired
	AaaServiceImpl(AaaMapper aaaMapper){
		this.aaaMapper = aaaMapper;
	}
	@Transactional //강제로 커밋을 하는 걸 해제함
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("a101a");		
	}
	
}
// 트랜젝션 오류 테스트
//3