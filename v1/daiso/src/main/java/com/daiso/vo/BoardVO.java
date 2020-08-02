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
public class BoardVO {
	private int b_num;
	private String b_title;
	private String b_writing;
	private Date b_date;
	private String m_userid;
	private int p_productid;
	
}
