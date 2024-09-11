package com.yedam.app.board.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // AOP => @Transactional
public class BoardServiceImpl implements BoardService{
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper){
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
		return result == 1 ? boardVO.getBno() : -1; //단건조회와 연결하는 것이 목적이기 때문에 이렇게 씀
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean done = false;
		int result = boardMapper.registerNewBoard(boardVO);
		
		if(result == 1) {
			done = true;
		}
		
		String updateDate = getUpadteDate(); //이 작업은 60번줄부터 시작하는 메소드이다.
		
		map.put("date", updateDate);
		map.put("done", done);
		map.put("target", boardVO);
		
		return map;
	}
	
	private String getUpadteDate() {//인터페이스(BoardService)에 등록된 메소드가 아니라서 외부에서 쓸 수 없다.
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd"); //날짜 포맷 함수
		String updateDt = today.format(dtFormat);
		return updateDt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardMapper.dropBoard(boardNo);
	}
	
}
//5번째