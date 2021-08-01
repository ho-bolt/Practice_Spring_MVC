package com.test.view.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
public class DeleteMsgController{
	
	@RequestMapping(value="/deleteMsg.do")
	public String deleteMsg(MessageVO vo,MessageDAO dao) throws Exception {

		System.out.println("삭제 컨트롤러");
		
		dao.DeleteMessage(vo);
	
		return "getMsgList.do";
	}
	
}
