package com.test.view.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;


@Controller
public class UpdateMsgController {
	@RequestMapping(value="/updateMsg.do")
	public String updateMsg(MessageVO vo,MessageDAO dao) throws Exception {
		
		System.out.println("수정 컨트롤러");
		
		dao.UpdateMessage(vo);
		
		
		return "getMsgList.do";
	}
	
}
