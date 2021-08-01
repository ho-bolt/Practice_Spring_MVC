package com.test.view.message;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
@SessionAttributes("msgData")
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
	public String updateMsg(@ModelAttribute("msgData")MessageVO vo,MessageDAO dao) throws Exception {
		
		System.out.println("수정 컨트롤러");
		//jsp view에서 사용자가 입력하지 않은 값에 대해서는 null이 들어온다. 
		//하지만 상단에 @sessionAttribute를 달고 들어오는 vo에 @modelAttribute를 붙이면
		//null값이 들어왔을 때 이것을 참고한다.
		dao.UpdateMessage(vo);
		
		
		return "getMsgList.do";
	}
	
	@RequestMapping(value="/getMsg.do")
	public String getMsg(MessageVO vo,MessageDAO dao, Model m) throws Exception {
		
		System.out.println("id값 게시글 보기 ");
		
		 
		 MessageVO v=dao.getMsg(vo);
		 m.addAttribute("msgData",v);
		
		 return "getMsg.jsp";
	}
	
	@ModelAttribute("resultMap")//검색 메소드 resultMap이라고 이름 붙임 
	public HashMap<String, String> searchMap() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("작성자", "writer");
		map.put("내용", "content");
		return map;
	}
	/*
	@RequestMapping(value="/getMsgList.do")
	public String getMsgList(@RequestParam(value="search",defaultValue="writer",required=false)String search,@RequestParam(value="searchContent",defaultValue="writer",required=false)String searchContent,MessageDAO dao, Model m)  {//command 객체
		//검색으로 들어온 값이 항상 있냐? 아니니까 false 
		System.out.println("메세지 목록 출력중 컨트롤러 ");
		
		 System.out.println(search);
		 System.out.println(searchContent);
		// List<MessageVO> msgList=dao.getMsgList(vo);
		// HttpSession session=request.getSession();
		// session.setAttribute("msgList", msgList);
		// m.addAttribute("msgList", msgList);
		 
		 return "getMsgList.jsp";
	
	}
	*/
	@RequestMapping(value="/getMsgList.do")
	public String getMsgList(MessageVO vo,MessageDAO dao, Model m)  {//command 객체
		//검색으로 들어온 값이 항상 있냐? 아니니까 false 
		System.out.println("메세지 목록 출력중 컨트롤러 ");
		
		 List<MessageVO> msgList=dao.getMsgList(vo);
		 m.addAttribute("msgList", msgList);
		 
		 return "getMsgList.jsp";
	
	}
	
}
