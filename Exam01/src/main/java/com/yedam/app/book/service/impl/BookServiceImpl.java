package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	private BookMapper bookmapper;	
	
	@Autowired
	public BookServiceImpl(BookMapper bookmapper) {
		this.bookmapper = bookmapper;
	}
	
	@Override
	public int insertBook(int bookNo) {// bookVO bookvo
		int result = bookmapper.insertBookData(bookNo);
		return result;
	}
	
	@Override
	public List<BookVO> list() {
		return bookmapper.bookList();
	}

	@Override
	public List<BookVO> rentList() {
		return bookmapper.rentInfo();
	}

}
//4번