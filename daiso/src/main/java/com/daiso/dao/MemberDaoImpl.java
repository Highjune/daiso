package com.daiso.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.daiso.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

//	@Autowired
//	private SqlSession sqlSession;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	//register에서 회원가입시
	public int create(MemberVO member) {
		String sql = "INSERT INTO membertable(m_userid, m_password, m_nickname, m_email, m_role, m_enabled)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql, member.getM_userid(), member.getM_password(), member.getM_nickname(),
				member.getM_email(), "ROLE_MEMBER", 1);
	}

	//로그인시 계정 맞는지 확인
	@Override
	public MemberVO getUserByUserid(String username) {
		String sql = "SELECT * FROM membertable WHERE m_userid = ?";
		
		return this.jdbcTemplate.queryForObject(sql, new String[] { username }, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO member = new MemberVO();
				member.setM_userid(rs.getString("m_userid"));
				member.setM_password(rs.getString("m_password"));
				member.setM_nickname(rs.getString("m_nickname"));
				member.setM_email(rs.getString("m_email"));
				member.setM_role(rs.getString("m_role"));
				member.setM_enabled(rs.getString("m_enabled"));

				return member;
			}
		});
	}
	
}
