package com.test.view.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
public class GetMsgListController {

	@RequestMapping(value="/getMsgList.do")
	public ModelAndView getMsgList(MessageVO vo,MessageDAO dao,ModelAndView mav)  {//command 객체

		System.out.println("메세지 목록 출력중 컨트롤러 ");
		
		 
		 List<MessageVO> msgList=dao.getMsgList(vo);
		// HttpSession session=request.getSession();
		 //session.setAttribute("msgList", msgList);
		 
		 mav.addObject("msgList", msgList);
		 mav.setViewName("getMsgList.jsp");
		 return mav;
		
		
		
		
		
	}
	
}
