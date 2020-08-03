package com.daiso.service;

import java.util.List;
import java.util.Map;

import com.daiso.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
//	List<BoardVO> selectBoard(int b_num);
	void selectBoard(Map map);
	void selectAllBoards(Map map);
	void updateBoard(BoardVO board);
	void deleteBoard(int b_num);


}
