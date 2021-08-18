package com.test.myapp.message;

import java.util.List;

import javax.servlet.http.HttpSession;


public interface MessageService {
	public void insertMessage(MessageVO vo);
	public void deleteMessage(MessageVO vo);
	public void updateMessage(MessageVO vo);
	public MessageVO getMsg(MessageVO vo);
	public List<MessageVO>getMsgList(MessageVO vo);
	
}
