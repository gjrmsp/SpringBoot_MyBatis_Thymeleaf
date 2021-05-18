package com.sana.s1.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sana.s1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Controller 진입 전 실행");
		// Controller 진입전
//		HttpSession session= request.getSession();
//		Object obj = session.getAttribute("member");
//		MemberVO memberVO=null;
//		boolean result= false;
//		
//		if(obj != null) {
//			memberVO = (MemberVO)obj;
//			if(memberVO.getUsername().equals("admin")) {
//				result = true;
//			}
//		}
//		 
//		if(!result) {
//			 
//			response.sendRedirect("/member/login");
//		}
//		request.setAttribute("name", "data");
//		RequestDispatcher view = request.getRequestDispatcher("view경로");
//		view.forward(request, response);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//Contrller 종료 후 실행
		System.out.println("Controller 종료 후");
		Map<String, Object> map = modelAndView.getModel();
		Iterator<String> it = map.keySet().iterator();

		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			System.out.println(map.get(key));
		}

		//view 경로를 확인하거나 변경 가능
		//modelAndView.getViewName();
		//modelAndView.setViewName("");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// Client 전송 전
		System.out.println("Client 전송 전");
	}
}