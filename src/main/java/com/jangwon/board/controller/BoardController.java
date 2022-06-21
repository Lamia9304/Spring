package com.jangwon.board.controller;

import com.jangwon.board.dto.BoardDTO;
import com.jangwon.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
    public class BoardController{

        private BoardService boardService;

        public BoardController(BoardService boardService) {
            this.boardService = boardService;
        }

        @GetMapping("/")
        public String list(){
            return "board/list.html";
        }
        @GetMapping("/post")
        public String post(){
            return "board/post.html";
        }

        @PostMapping("/post")
        public String write(BoardDTO boardDTO)
        {
            boardService.savePost(boardDTO);
            return "redirect:/";
        }


    }



