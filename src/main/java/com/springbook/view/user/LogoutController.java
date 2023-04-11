package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout.do")
	public String handleRequest(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		
		session.invalidate();
		return "login.jsp";
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�α׾ƿ� ó��");
//		
//		//1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
//		HttpSession session = request.getSession();
//		session.invalidate();
//		
//		//2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
////		return "login";
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:login.jsp");
//		return mav;
//	}
	
}
