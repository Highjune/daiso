package com.daiso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daiso.dao.ReviewDao;
import com.daiso.vo.ReviewVO;

@Service("reivewService")
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	

	@Override
	public void insertReview(ReviewVO review) {
		this.reviewDao.create(review);
	}


	@Override
	public List<ReviewVO> selectReview(int b_num) {	
		List<ReviewVO> list = this.reviewDao.readAll(b_num);
		return list;
	}

	@Override
	public void deleteReview(int r_num) {
		this.reviewDao.delete(r_num);		
	}

	
}
