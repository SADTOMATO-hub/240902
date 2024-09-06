package com.yedam.app.AOP.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	@Insert("INSERT INTO aaa VALUES (#{value})")
	public int insert(String value);
}
//트랜젝셔널 연습
//1