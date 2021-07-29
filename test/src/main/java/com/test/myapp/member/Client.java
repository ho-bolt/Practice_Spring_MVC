package com.test.myapp.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.myapp.message.MessageService;
import com.test.myapp.message.MessageVO;
import com.test.myapp.message.impl.MessageDAO;

public class Client {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MessageService ms=(MessageService)factory.getBean("MessageService"); //MessageServiceImpl에 @Service(MessageService)를 달아주었다. 여기서 getBean으로 얘를 쓴다고 말해준다.
		MessageVO vo=new MessageVO();
		MessageDAO messageDAO=new MessageDAO();
		
		vo.setWriter("홍길동");
		vo.setContent("허준");
		ms.updateMessage(vo);
		
		
		List<MessageVO> datas=ms.getMsgList(vo);
		for(MessageVO v:datas) {
			System.out.println(v);
		}
			
		
		
		factory.close();
	}
}
