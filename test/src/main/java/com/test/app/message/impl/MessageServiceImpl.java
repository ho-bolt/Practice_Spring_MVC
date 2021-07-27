package com.test.app.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.message.MessageService;
import com.test.app.message.MessageVO;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDAO messageDAO;
	
	public void deleteMessage(MessageVO vo) {
		messageDAO.DeleteMessage(vo);
	}
	public MessageVO getMsg(MessageVO vo) {
		return messageDAO.getMsg(vo);
	}
	public List<MessageVO> getMsgList(MessageVO vo) {
		return messageDAO.getMsgList(vo);
	}
	public void insertMessage(MessageVO vo) {
		messageDAO.InsertMessage(vo);
	}
	public void updateMessage(MessageVO vo) {
		messageDAO.UpdateMessage(vo);
			
	}
	
}
