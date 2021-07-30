package com.test.view.message;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

public class InsertMsgController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("메세지 등록 컨트롤러");
			String writer=request.getParameter("writer");
			String content=request.getParameter("content");
			
			MessageVO vo=new MessageVO();
			MessageDAO dao=new MessageDAO();
			
			vo.setWriter(writer);
			vo.setContent(content);
			
			dao.InsertMessage(vo);
			
			ModelAndView mav=new ModelAndView();
			mav.setViewName("index.jsp");
			
	
		return mav;
	}
}
