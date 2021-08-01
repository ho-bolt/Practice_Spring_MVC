package com.test.view.message;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
public class MessageController {
	
	@RequestMapping(value="/insertMsg.do")
	public String insertMsg(MessageVO vo,MessageDAO dao) throws Exception {  
		
			System.out.println("메세지 등록 컨트롤러");				
			dao.InsertMessage(vo);		
			return "getMsgList.do"; //redirect : 
	}
	
	@RequestMapping(value="/deleteMsg.do")
	public String deleteMsg(MessageVO vo,MessageDAO dao) throws Exception {

		System.out.println("삭제 컨트롤러");
		
		dao.DeleteMessage(vo);
	
		return "getMsgList.do";
	}
	
	
	@RequestMapping(value="/updateMsg.do")
	public String updateMsg(MessageVO vo,MessageDAO dao) throws Exception {
		
		System.out.println("수정 컨트롤러");
		
		dao.UpdateMessage(vo);
		
		
		return "getMsgList.do";
	}
	@RequestMapping(value="/getMsg.do")
	public ModelAndView getMsg(MessageVO vo,MessageDAO dao, ModelAndView mav) throws Exception {
		
		System.out.println("id값 게시글 보기 ");
		
		 
		 MessageVO v=dao.getMsg(vo);
		 
		 mav.addObject("v",v);
		 mav.setViewName("getMsg.jsp");
		 return mav;
	}
	
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
