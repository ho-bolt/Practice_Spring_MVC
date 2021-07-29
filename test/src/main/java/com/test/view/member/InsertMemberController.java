package com.test.view.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.myapp.member.MemberVO;
import com.test.myapp.member.impl.MemberDAO;

public class InsertMemberController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

			System.out.println("회원 등록중.. 컨트롤러");
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String role=request.getParameter("role");
			
			MemberDAO dao=new MemberDAO();
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setPassword(password);
			vo.setName(name);
			vo.setRole(role);
			dao.InsertMember(vo);
			
			ModelAndView mav=new ModelAndView();
			mav.setViewName("index.jsp");
			
			
			return mav;
	}
	
	
}
