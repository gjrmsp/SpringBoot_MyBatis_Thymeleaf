package com.sana.s1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Security를 무시(제외)
		web.ignoring()
		.antMatchers("/resources/**")	
		.antMatchers("/images/**")
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/vendor/**")
		.antMatchers("/favicon/**")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// URL에 따른 로그인, 권한 설정
		http
		//권한 에러 발생(403)
		.exceptionHandling()
		.accessDeniedPage(null) //error page 경로
		.accessDeniedHandler(null)//error 처리 class
		.and()
		.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/notice/list", "/notice/select").permitAll()
		.antMatchers("/notice/**").hasRole("ADMIN")
		.antMatchers("/qna/list").permitAll()
		.antMatchers("/qna/**").hasAnyRole("ADMIN", "MEMBER")
		.antMatchers("/member/join").permitAll()
		.antMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		// 로그인 페이지를 따로 만들지 않아도 기본 내장된 폼으로 이동
		// 개발자가 만든 로그인 폼을 사용하려면 다음과 같이 작성
		.loginPage("/member/login")
		.defaultSuccessUrl("/member/memberLoginResult")
		//Login 실패 처리
		//.failureUrl("/member/loginFail")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/member/logout")
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.permitAll()
		;
	}

}
