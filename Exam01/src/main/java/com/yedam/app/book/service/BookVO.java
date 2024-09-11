package com.yedam.app.book.service;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookVO {
	private Integer bookNo;
	private String bookName;
	private String bookCoverimg;
	private Date bookDate;
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
	private Integer rentNo;
	private Integer rentPrice;
	private Date rentDate;
	private Character status;
	private Integer sum;
	private Integer count;
}
//1번