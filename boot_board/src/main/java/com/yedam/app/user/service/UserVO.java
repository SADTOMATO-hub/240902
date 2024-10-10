package com.yedam.app.user.service;

import lombok.Data;

@Data /*getter setter toString*/
public class UserVO {
	//field
	//인터넷 페이지에서 payload를 확인하고 넘겨야할 데이터 이름을 참고
	private String id;
	private String password;
	private String name;
	private String gender;
	private String joinDate;
}
