package com.daiso.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class MemberVO {
	private String m_userid;
	private String m_password;
	private String m_nickname;
	private String m_email;
	private String m_role;
	private String m_enabled;
}
