package com.daiso.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.BoardDao;
import com.daiso.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public void insertBoard(BoardVO board) {
		this.boardDao.create(board);		
	}

	@Override
	public void selectBoard(Map map) {
		this.boardDao.read(map);		
	}
	@Override
	public void selectAllBoards(Map map) {
		this.boardDao.readAll(map);		
	}

	@Override
	public void updateBoard(BoardVO board) {
		this.boardDao.update(board);
	}
	
	@Override
	public void deleteBoard(int b_num) {
		this.boardDao.delete(b_num);		
	}

}
