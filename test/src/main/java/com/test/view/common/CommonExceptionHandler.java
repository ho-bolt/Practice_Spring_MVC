package com.test.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.test.view")//어디선가 문제가 발생하면, 내가 그거 담당할게!
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("controllerError/error.jsp");
		return mav;
		
	}
	//다른 에러페이지를 만들고 싶다면, Exception.class에 다른 에러를 넣어주고 다른 페이지를 넣어준다. 
	
	
}
