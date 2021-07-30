package com.test.view.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

public class GetMsgListController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("메세지 목록 출력중 컨트롤러 ");
		
		MessageVO vo=new MessageVO();
		 MessageDAO dao=new MessageDAO();
		 
		 List<MessageVO> msgList=dao.getMsgList(vo);
		// HttpSession session=request.getSession();
		 //session.setAttribute("msgList", msgList);
		 
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("msgList", msgList);
		 mav.setViewName("getMsgList.jsp");
		 return mav;
		 
		
		
		
		
		
	}
	
}
