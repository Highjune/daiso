package com.daiso.dao;

import java.util.List;
import java.util.Map;

import com.daiso.vo.BoardVO;

public interface BoardDao {
	void create(BoardVO board);
	void read(Map map);
//	List<BoardVO> read(int num);
	void readAll(Map map);
	void update(BoardVO board);
	void delete(int b_num);

	
}
