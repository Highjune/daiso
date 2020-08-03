package com.mapper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.daiso.vo.BoardVO;

@Mapper
public interface BoardMapper {

	@Update("UPDATE BOARD SET b_title=#{boardVO.b_title}, b_writing=#{boardVO.b_writing}, b_date=now(), m_userid=#{boardVO.m_userid},"
			+ "p_productid=#{boardVO.p_productid} WHERE b_num=#{boardVO.b_num}")
	void updateBoard(@Param("boardVO") BoardVO boardVO);

	@Delete("delete from board where b_num = #{num} ")
	void deleteBoard(int num);

//	@Select("SELECT * FROM board WHERE b_num=#{b_num}")
//	List<BoardVO> selectBoard(int num);

}
