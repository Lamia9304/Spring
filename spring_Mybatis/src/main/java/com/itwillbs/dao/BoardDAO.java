package com.itwillbs.dao;

import com.itwillbs.domain.BoardDTO;

public interface BoardDAO {

		//추상 메서드
		public void insertBoard(BoardDTO boardDTO);
		
		
// boardDAO.getMaxNum()
	public Integer getMaxNum();
	
}
