package com.test.myapp.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.myapp.message.MessageService;
import com.test.myapp.message.MessageVO;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MessageService ms=(MessageService)factory.getBean("MessageService"); //MessageServiceImpl에 @Service(MessageService)를 달아주었다. 여기서 getBean으로 얘를 쓴다고 말해준다.
		MessageVO vo=new MessageVO();
		vo.setContent("hello");
		vo.setWriter("user");
		
		ms.insertMessage(vo);
		
		vo.setMid(2);
	MessageVO data=ms.getMsg(vo);
	System.out.println(data);
		
		
		
		
		
		factory.close();
	}
}
