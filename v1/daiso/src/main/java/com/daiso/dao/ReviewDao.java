package com.daiso.dao;

import java.util.List;
import java.util.Map;

import com.daiso.vo.BoardVO;
import com.daiso.vo.ReviewVO;

public interface ReviewDao {
	void create(ReviewVO review);

	void read(Map map);
	
	void update(ReviewVO review);
	
	void delete(int r_num);

	List<ReviewVO> readAll(int b_num);
	
}
