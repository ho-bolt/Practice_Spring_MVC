package com.test.view.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

import oracle.jdbc.driver.Message;

public class GetMsgController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("id값 게시글 보기 ");
		String mid=request.getParameter("mid");
		
		MessageVO vo=new MessageVO();
		 MessageDAO dao=new MessageDAO(); 
		 
		 vo.setMid(Integer.parseInt(mid));
		 MessageVO v=dao.getMsg(vo);
		 
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("v",v);
		 mav.setViewName("getMsg.jsp");
	
		return mav;
	}
	
}		
