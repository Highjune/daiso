package com.daiso.dao;

import com.daiso.vo.MemberVO;

public interface MemberDao {

	MemberVO getUserByUserid(String username);
	
	int create(MemberVO member);
	
}
