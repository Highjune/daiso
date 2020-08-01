package com.daiso.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daiso.service.ReviewService;
import com.daiso.vo.ReviewVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	
	//댓글 쓰기
	@PostMapping("/review")
	public Map createreview(@RequestBody Map<String, String> map, HttpServletRequest http) {
		ReviewVO review = new ReviewVO();
		review.setM_userid(http.getUserPrincipal().getName());
		review.setR_comment(map.get("r_comment"));
		review.setB_num(Integer.parseInt(map.get("b_num")));
		this.reviewService.insertReview(review);
		return map;		
	}		
	
	@GetMapping("/review/{b_num}")
	public Map selectallreview(@PathVariable("b_num") int b_num) {
		List<ReviewVO> list = this.reviewService.selectReview(b_num);
		Map<String, Object> review = new HashMap<String, Object>();
		review.put("list", list);
		return review;		
	}	
	
	@DeleteMapping("/review/{r_num}")
	public Map delete(@PathVariable("r_num") int r_num) {
		this.reviewService.deleteReview(r_num);
		Map<String, String> review = new HashMap<String, String>();
		review.put("code", "success");
		return review;	
	}
	
	
//	@DeleteMapping("/review/{r_num}")
	
	
}
