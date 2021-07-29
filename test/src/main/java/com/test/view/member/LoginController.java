package com.test.view.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.myapp.member.MemberVO;
import com.test.myapp.member.impl.MemberDAO;

public class LoginController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		
		vo.setId(id);
		vo.setPassword(password);
		dao.Login(vo);
		
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("index.jsp");
		
		return mav;
	}
	
}
