package com.daiso.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daiso.dao.MemberDao;
import com.daiso.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberService")
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = this.memberDao.getUserByUserid(username);
		log.info("검색된 멤버 = {}", member.toString());
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(member.getM_role()));
		UserDetails user = new User(member.getM_userid(), "{noop}" + member.getM_password(), roles);
		return user;
	}

	@Override
	public void insertMember(MemberVO member) {
		this.memberDao.create(member);		
	}	
	

}
