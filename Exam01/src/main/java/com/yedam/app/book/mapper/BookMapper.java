package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	//도서등록
		public int insertBookData (int bookNo);
	//도서목록 조회/수정
		public List<BookVO> bookList ();
	//대여현환조회
		public List<BookVO> rentInfo ();
}
//2번