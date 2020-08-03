package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.BoardVO;
import com.mapper.mapper.BoardMapper;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	BoardMapper boardMapper;

	@Override
	public void create(BoardVO board) {
		this.sqlSession.insert("boardInsert", board);
	}

	@Override
	public void read(Map map) {
		Map<String, Object> mapping = this.sqlSession.selectOne("boardSelectOne", map);
		System.out.println(mapping);
		map.put("selectOneResult", mapping); // controller에서 "selectOneResult" key 값으로 들고옴
	}

//	@Override
//	public List<BoardVO> read(int num) {
//		return boardMapper.selectBoard(num);
//		// TODO Auto-generated method stub
//	}

	@Override
	public void readAll(Map map) {
		List<Object> list = this.sqlSession.selectList("boardSelectAll", map);
		map.put("results", list); // controller에서 "results" key 값으로 list 다 들고옴
	}

	@Override
	public void update(BoardVO board) {
		boardMapper.updateBoard(board);
	}

//	@Override
//	public void delete(int b_num) {
//		this.sqlSession.delete("boardDelete", b_num);
//	}

	@Override
	public void delete(int b_num) {
		// TODO Auto-generated method stub
		this.boardMapper.deleteBoard(b_num);
	}

}
