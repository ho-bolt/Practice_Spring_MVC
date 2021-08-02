package com.test.view.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.myapp.member.MemberService;
import com.test.myapp.member.MemberVO;
import com.test.myapp.member.impl.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(MemberVO vo,HttpSession session) throws Exception {
	
		
		System.out.println("로그인 컨트롤러");
		
		MemberVO data=memberService.Login(vo);
		if(data!=null) {
			//유
//			session.setAttribute("memberName", data.getName());
//			session.setAttribute("memberId", data.getId());
//			session.setAttribute("memberPassword", data.getPassword());
//			session.setAttribute("memberRole", data.getRole());
			session.setAttribute("vvv", data);
			return "index.jsp";		
		}
		else {
			return "login.jsp";
					
		}
	
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login2(@ModelAttribute("member")MemberVO vo)  { 

		System.out.println("로그인 화면을 서비스하는 메서드get방식 ");
		vo.setId("admin");
		vo.setPassword("1234");
		
		
		return "login.jsp";
	
	}
	
	
	@RequestMapping(value="/insertMember.do")
	public String insertMember(MemberVO vo,Model m)  {

			System.out.println("회원 등록중.. 컨트롤러");			
			memberService.insert(vo);
			vo=memberService.Login(vo);
			m.addAttribute("v",vo);
			return "index.jsp";
	}
	
	@RequestMapping(value="logout.do")
		public String logout(HttpSession session) {
		System.out.println("로그아웃 컨트롤러");
			
		session.invalidate();
		
		return "index.jsp";
				
		
		
	}
	
}
