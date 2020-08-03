package com.daiso.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daiso.vo.ReviewVO;
import com.mapper.mapper.ReviewMapper;

@Repository("reviewDao")
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	private ReviewMapper reviewMapper;	
	
	@Override
	public void create(ReviewVO review) {
		this.reviewMapper.insertReivew(review);		
		
	}

	@Override
	public void read(Map map) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<ReviewVO> readAll(int b_num) {
		List<ReviewVO> list = this.reviewMapper.selectReview(b_num);
		return list;
	}

	@Override
	public void update(ReviewVO review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int r_num) {
		this.reviewMapper.deleteReview(r_num);		
	}

}
