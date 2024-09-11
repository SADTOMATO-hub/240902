package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardCont {
	private BoardService boardService;
	
	public BoardCont(BoardService boardService) {
		this.boardService = boardService;
	}
		//전체
	@GetMapping("boardList")
	public String listUPBoard(Model model){
		List<BoardVO> boardlist = boardService.boardList();
		model.addAttribute("board", boardlist); 
		return "board/boardList";
	}
		//단건
	@GetMapping("boardInfo")
	public String boardInformation(int bno, Model model) {
		BoardVO boardInformation = boardService.boardInfo(bno);
		model.addAttribute("boardInfo", boardInformation);
		return "board/boardInfo";
	}
		//등록 페이지
	@GetMapping("boardInsertForm")
	public String goToInsertForm() {
		return "board/boardInsert";
	}
		//등록 기능
	@PostMapping("boardInsert")
	public String insertNewBoard(BoardVO boardVO) {//QueryString = <form/>태그를 활용한 submit을 쓰겠다.
		int bno = boardService.insertBoard(boardVO);
		String url = "redirect:boardInfo?bno=";
		return url + bno;
	}
		//수정 페이지
	@GetMapping("boardUpdateForm")
	public String goToUpdateForm(int boardNo, Model model) {
		BoardVO bInfo = boardService.boardInfo(boardNo);
		model.addAttribute("boardInfo",bInfo);
		return "board/boardUpdate"; 
	}
		//수정 기능
	@PostMapping("boardUpdate")
	@ResponseBody //AJAX 형태를 쓰겠다
	public Map<String, Object> boardUpdate(@RequestBody BoardVO boardVO){//단일 값이 아니기 떄문에 @RequestBody
		return boardService.updateBoard(boardVO);
	}
	
		//삭제 기능
	@GetMapping("boardDelete") //단일 값을 쓰겠다 = QueryString 중에 @RequestParam
	public String deleteBoard(@RequestParam Integer boardNo) {//선택사항이지만 쓰는 것을 권유함
		boardService.deleteBoard(boardNo);
		return "redirect:boardList";
	}
}
//6번째