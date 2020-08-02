package com.daiso.service;

import java.util.Map;

import com.daiso.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO board);
	void selectBoard(Map map);
	void selectAllBoards(Map map);
	void updateBoard(BoardVO board);
	void deleteBoard(int b_num);

}
