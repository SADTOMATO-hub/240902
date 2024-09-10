package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//전체조회
		public List<BoardVO> selectBoardList();
	//단건조회
		public BoardVO selectBoardInformation(int bno);
	//등록
		public int registerNewBoard(BoardVO boardVO);
	//수정
		public int updateBoard(BoardVO boardVO);
	//삭제
		public int dropBoard(int bno);
}	
//2번째