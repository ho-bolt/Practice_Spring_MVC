package com.test.view.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.myapp.member.MemberVO;
import com.test.myapp.member.impl.MemberDAO;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO vo,MemberDAO dao) throws Exception {

		dao.Login(vo);
	
		return "index.jsp";
	}
	
	@RequestMapping(value="/insertMember.do")
	public String insertMember(MemberVO vo, MemberDAO dao) throws Exception {

			System.out.println("회원 등록중.. 컨트롤러");			
			dao.InsertMember(vo);
			return "index.jsp";
	}
	
	
	
}
