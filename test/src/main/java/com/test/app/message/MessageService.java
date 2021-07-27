package com.test.app.message;

import java.util.List;


public interface MessageService {
	public void insertMessage(MessageVO vo);
	public void deleteMessage(MessageVO vo);
	public void updateMessage(MessageVO vo);
	public MessageVO getMsg(MessageVO vo);
	public List<MessageVO>getMsgList(MessageVO vo);
	
}
