package com.yedam.app.book.service;

import java.util.List;


public interface BookService {
	public int insertBook(int bookNo);
	public List<BookVO> list();
	public List<BookVO> rentList();
}
//3번