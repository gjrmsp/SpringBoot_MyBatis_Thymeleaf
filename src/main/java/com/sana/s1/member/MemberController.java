package com.sana.s1.member;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public String setJoin(@ModelAttribute MemberVO memberVO) throws Exception {
		return "member/memberJoin";
	}

	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO, Errors errors, MultipartFile avatar) throws Exception {
		System.out.println("Join Process" + memberVO.getName().length());

//		if(errors.hasErrors()) {
//		return "member/memberJoin";
//		}

		if(memberService.memberError(memberVO, errors)) {
			return "member/memberJoin";
		}

		int result = memberService.setJoin(memberVO, avatar);
		return "redirect:../";
	}

	@GetMapping("login")
	public String getLogin() throws Exception {
		return "member/memberLogin";
	}

	@GetMapping("loginFail")
	public String loginFail() throws Exception {
		System.out.println("Login Fail");
		return "redirect:/member/login";
	}

	@GetMapping("memberLoginResult")
	public String memberLoginResult(HttpSession session, Authentication auth2) throws Exception {

		//session의 속성명들 꺼내오기 
		Enumeration<String> en = session.getAttributeNames();

		while(en.hasMoreElements()) {
			System.out.println("Attribute Name : "+en.nextElement());
		}

		//로그인 시 session의 속성명 : SPRING_SECURITY_CONTEXT
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");

		SecurityContextImpl sc = (SecurityContextImpl)obj;

		Authentication auth= sc.getAuthentication();
		System.out.println("===================================");
		System.out.println("Name : "+auth.getName());
		System.out.println("Details : "+auth.getDetails());
		System.out.println("Principal : "+auth.getPrincipal());
		System.out.println("Authorities : "+auth.getAuthorities());
		System.out.println("===================================");

		System.out.println("===================================");
		System.out.println("Name : "+auth2.getName());
		System.out.println("Details : "+auth2.getDetails());
		System.out.println("Principal : "+auth2.getPrincipal());
		System.out.println("Authorities : "+auth2.getAuthorities());
		System.out.println("===================================");

		System.out.println(obj);
		System.out.println("Login 성공");
		return "redirect:/";
	}
	
//	@PostMapping("login")
//	public String getLogin(MemberVO memberVO, HttpSession session) throws Exception {
//		memberVO = memberService.getLogin(memberVO);
//		//session.setAttribute("member", memberVO);
//
//		if(memberVO != null) {
//			session.setAttribute("member", memberVO);
//		}
//
//		return "redirect:/";
//	}

	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
}
