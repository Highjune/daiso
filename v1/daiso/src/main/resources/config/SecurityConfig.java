package com.example.config;

import javax.sql.DataSource;

import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MemberService memberService;

//	@Autowired
//	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws java.lang.Exception{
		log.info("called configure()");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/new/**").authenticated();
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");

		http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");

		http.userDetailsService(memberService);
	}

//	protected void configure(AuthenticationManagerBuilder auth) throws java.lang.Exception{
//		String sql1 = "SELECT userid AS username, passwd AS password, enabled FROM Member " +
//					         "WHERE userid = ?";
//		String sql2 = "SELECT userid, role FROM Member WHERE userid = ?";
//		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(sql1)
//		.authoritiesByUsernameQuery(sql2);
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
}





