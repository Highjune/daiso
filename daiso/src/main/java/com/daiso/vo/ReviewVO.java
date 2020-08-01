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
public class ReviewVO {
	private int r_num;
	private String r_comment;
	private Date r_date;
	private int b_num;
	private String m_userid;
}
