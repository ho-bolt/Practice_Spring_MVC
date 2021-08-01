package com.test.view.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
public class GetMsgController{
	
	@RequestMapping(value="/getMsg.do")
	public ModelAndView getMsg(MessageVO vo,MessageDAO dao, ModelAndView mav) throws Exception {
		
		System.out.println("id값 게시글 보기 ");
		
		 
		 MessageVO v=dao.getMsg(vo);
		 
		 mav.addObject("v",v);
		 mav.setViewName("getMsg.jsp");
		 return mav;
	}
	
}		
