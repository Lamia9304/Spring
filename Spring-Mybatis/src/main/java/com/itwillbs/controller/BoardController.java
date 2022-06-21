package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String insert() {
		// WEB-INF/views/board/write.jsp
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/writePro", method=RequestMethod.POST)
	public String writePro(BoardDTO boardDTO) {
		//디비 insert
		boardService.insertBoard(boardDTO);
		
		return "redirect:/board/list";
		
	}
	
	
	

}
