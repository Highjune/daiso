package com.mapper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.daiso.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	@Update("UPDATE BOARD SET b_title=#{boardVO.b_title}, b_writing=#{boardVO.b_writing}, b_date=now(), m_userid=#{boardVO.m_userid},"
			+ "p_productid=#{boardVO.p_productid} WHERE b_num=#{boardVO.b_num}")
	void updateBoard(@Param("boardVO")BoardVO boardVO);	
	
}
