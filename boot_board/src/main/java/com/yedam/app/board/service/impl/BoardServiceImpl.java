package com.yedam.app.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // AOP => @Transactional
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;

	@Autowired
	BoardServiceImpl(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO boardInfo(int bno) {
		return boardMapper.selectBoardInformation(bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = boardMapper.registerNewBoard(boardVO);
		return result == 1 ? boardVO.getBno() : -1;
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardVO) {
		return null;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return 0;
	}
	
}
//5번째