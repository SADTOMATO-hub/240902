package com.yedam.app.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookVO;

@Controller
public class BookCont {
	private BookMapper bookmapper;
	
	@Autowired
	public BookCont(BookMapper bookmapper) {
		this.bookmapper = bookmapper;
	}
	
	@GetMapping("bookList")
	public String bookList(Model model){
		List<BookVO> list = bookmapper.bookList();
		model.addAttribute("bookList", list);
		return "book/bookList";
	}
	
	@GetMapping("bookInsertForm")
	public String bookInsertForm() {
		return "book/bookInsertForm";
	}
	
	@PostMapping("bookInsertData")
	public String bookInsertData(@RequestParam Integer bookNo) {
		bookmapper.insertBookData(bookNo); 
		return "redirect:bookList";
	}
	
	@GetMapping("rentInfo")
	public String rentInfo(Model model) {
		List<BookVO> list = bookmapper.rentInfo();
		model.addAttribute("rentInfo",list);
		return "book/rentInfo";
	}
}
