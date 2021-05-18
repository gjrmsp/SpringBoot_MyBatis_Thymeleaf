package com.sana.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sana.s1.member.MemberVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	//controller 진입전 admin 판별
	//admin이면 진행
	//아니면 
	//1. 로그인 폼으로 리다이렉트
	//2. 권한이 없음 alert, index로 이동

	// AdminInterceptorConfig
	// /notice/insert, update, delete
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			// page
			// request
			// session
			// application

		System.out.println("PreHandle 시작");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");

		boolean result=false;

		if(memberVO != null && memberVO.getUsername().equals("admin")) {
			result = true;
		} else {
			//1. redirect login 
			response.sendRedirect("/member/login");
			//2. foward
//			request.setAttribute("msg", "관리자가 아님");
//			request.setAttribute("path", "../member/login");
//			RequestDispatcher view = request.getRequestDispatcher("classpath:/templates/common/result.html");
//			System.out.println("Foward");
//			view.forward(request, response);
		}
		return result;
	}
}
