package com.daiso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.daiso.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MemberService memberService;

	@Override
	protected void configure(HttpSecurity http) throws java.lang.Exception{
		log.info("called configure()");
		
//		http.csrf().disable();
		
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/board/**").authenticated(); //board는 로그인 승인된 사람들만 볼 수 있게.
//		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER"); 
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		http.formLogin().loginPage("/login").defaultSuccessUrl("/", true); //로그인 되었을 때 홈으로 redirect
		http.exceptionHandling().accessDeniedPage("/accessDenied");  //권한이 없을 경우 accessDenied 페이지로
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
		http.csrf().ignoringAntMatchers("/board/**").and(); //boardwrite에서 글 써서 넘길 때 form(csrf hidden보냄) 쓰지 않아서.
		
		http.userDetailsService((UserDetailsService) memberService);
	}
	
}
