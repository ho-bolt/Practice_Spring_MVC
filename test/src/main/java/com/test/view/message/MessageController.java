package com.test.view.message;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.myapp.message.MessageService;
import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

@Controller
@SessionAttributes("msgData")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	//비즈니스 컴포넌트
	@RequestMapping(value="/insertMsg.do")
	public String insertMsg(MessageVO vo,Model m) throws Exception {  //command 객체
		
		File file=null;
			System.out.println("메세지 등록 컨트롤러");	
//			String fileName="";
//			MultipartFile uploadFile=vo.getUploadFile();
//			if(!uploadFile.isEmpty()) {
//				 fileName=uploadFile.getOriginalFilename();
//				 file=new File("D:\\0615Spring_seo\\resource"+fileName);
//				 //file객체를 바이트 배열로 변환
//				//System.out.println(fileName);//pig.png 확장자와 이름까지만 보여준다
//			uploadFile.transferTo(new File("D:\\0615Spring_seo\\resource"+fileName));
//			//업로드한 파일을 관리하는 경로를 작성해두면 다운가능 
//			}
//			else {
//				System.out.println("진행안함");
//			}
//			System.out.println("파일업로드"+fileName);
			messageService.insertMessage(vo);	
			return "getMsgList.do"; //redirect : 
	}
	
	@RequestMapping(value="/deleteMsg.do")
	public String deleteMsg(MessageVO vo) throws Exception {

		System.out.println("삭제 컨트롤러");
		
		messageService.deleteMessage(vo);
	
		return "getMsgList.do";
	}
	
	
	@RequestMapping(value="/updateMsg.do")
	public String updateMsg(@ModelAttribute("msgData")MessageVO vo) throws Exception {
		
		System.out.println("수정 컨트롤러");
		//jsp view에서 사용자가 입력하지 않은 값에 대해서는 null이 들어온다. 
		//하지만 상단에 @sessionAttribute를 달고 들어오는 vo에 @modelAttribute를 붙이면
		//null값이 들어왔을 때 이것을 참고한다.
		messageService.updateMessage(vo);
		
		
		return "getMsgList.do";
	}
	
	@RequestMapping(value="/getMsg.do")
	public String getMsg(MessageVO vo, Model m) throws Exception {
		
		System.out.println("id값 게시글 보기 ");
		
		 
		 MessageVO v=messageService.getMsg(vo);
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
	//command객체 사용
	@RequestMapping(value="/getMsgList.do")
	public String getMsgList(MessageVO vo, Model m)  {//command 객체
		//검색으로 들어온 값이 항상 있냐? 아니니까 false 
		System.out.println("메세지 목록 출력중 컨트롤러 ");
		//검색하지 않았을 때도 필요하다
		if(vo.getSearch()==null) {
			vo.setSearch("writer");
		}
		else if(vo.getSearchContent()==null) {
			vo.setSearchContent("");
		}
		 List<MessageVO> msgList=messageService.getMsgList(vo);
		 m.addAttribute("msgList", msgList);
		 System.out.println(msgList);
		 return "getMsgList.jsp";
	}
	
}
