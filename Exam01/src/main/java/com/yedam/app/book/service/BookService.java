package com.yedam.app.book.service;

import java.util.List;


public interface BookService {
	public int insertBook(int bookNo);// bookVO bookvo
	public List<BookVO> list();
	public List<BookVO> rentList();
}
//3번