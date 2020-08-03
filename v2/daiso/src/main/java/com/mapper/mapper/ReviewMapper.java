package com.mapper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.daiso.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
	
	@Insert("INSERT INTO review values(#{reviewVO.r_num},#{reviewVO.r_comment},now(),#{reviewVO.b_num},#{reviewVO.m_userid})")	
	void insertReivew(@Param("reviewVO")ReviewVO reviewVO);

	@Select("SELECT * FROM review WHERE b_num = #{b_num}")
	List<ReviewVO> selectReview(int b_num);
	
	@Delete("DELETE FROM review WHERE r_num=#{b_num}")
	void deleteReview(int r_num);
	
	
}
