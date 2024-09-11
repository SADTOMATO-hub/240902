package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@Builder
public class BoardVO {
	private Integer bno;	   //번호 BNO, 프라이머리, 정수값
	private String title;	   //제목 TITLE
	private String contents;   //내용 CONTENTS
	private String writer;     //작성자 WRITE
	@DateTimeFormat(pattern = "yyyy-MM-dd") //html을 서버에서 처리할 때
	private Date regdate;	   //작성일 REGDATE
	private Date updatedate;   //수정일 UPDATEDATE
	private String image;      //첨부이미지 IMAGE
}
// 1번째