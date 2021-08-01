package com.test.view.message;




//@Controller 		//이것은 2번째 @을 이용한 방법 handlerMapping을 지우고, void, insertMsg을 메소드명으로 써준다. 
//						//POJO spirng MVC에서 제공하는 Controller를 implements한 클래스는 POJO 클래스 XX
//public class InsertMsgController {
//				//일반적인 메소드를 이용할 것이기 때문에 ModelAndView가 필요가 없다. 
//				// HttpServletResponse response가 필요없다. 왜냐하면, modelandview처럼 받아서 전달할 것이 없기 때문이다. 
//	@RequestMapping(value="/insertMsg.do")
//	public String insertMsg(MessageVO vo,MessageDAO dao) throws Exception {  //command객체란 controller 클래스의 메소드에서 매개변수로 
//		//적용되기 대문에 http Request가 아니라, VO로 세팅하기 때문에,MessageVO가 들어간다. 이것이 바로 command객체이다.
//		//원래 메소드가 실행될 때 인자값을 가장 먼저 처리하려고 한다. 따라서 지금 인자값인 vo를 가장 먼저 만든다.
//			System.out.println("메세지 등록 컨트롤러");
//			
//			//String writer=request.getParameter("writer");
//			//String content=request.getParameter("content");
//			
//			//MessageVO vo=new MessageVO();
////			vo.setWriter(writer);
////			vo.setContent(content);			
//			dao.InsertMessage(vo);
//			
//			//ModelAndView mav=new ModelAndView();
//			//mav.setViewName("index.jsp");
//			//이렇게 vo값을 받아서 세팅하고 dao에 넣는 것을 command객체에서 하기 때문에 필요가 없다.
//			
//			return "getMsgList.do"; //redirect : 
//
//	
//	}
//}
