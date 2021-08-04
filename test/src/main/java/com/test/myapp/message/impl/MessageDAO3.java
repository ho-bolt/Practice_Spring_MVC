package com.test.myapp.message.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.test.myapp.message.MessageVO;
import com.test.myapp.util.SqlSessionFactoryBean;

@Repository("messageDAO3")
public class MessageDAO3 {
	
	private SqlSession mybatis;
	
	public MessageDAO3() {
		mybatis=SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void InsertMessage(MessageVO vo) {
		System.out.println("메세지 삽입 mabatis");
		mybatis.insert("MessageDAO3.insertMessage", vo);
		mybatis.commit();
	}
	public void DeleteMessage(MessageVO vo) {
		System.out.println("메세지 삭제 mabatis");
		mybatis.delete("MessageDAO3.deleteMessage", vo);
		mybatis.commit();
	}
	
	public void UpdateMessage(MessageVO vo) {
		
		System.out.println("메세지 수정 mabatis");
		mybatis.update("MessageDAO3.updateMessage", vo);
		mybatis.commit();
		
	}
	
	public MessageVO getMsg(MessageVO vo) {
		System.out.println("유저 정보 가져오기 mabatis");
		
		return (MessageVO)mybatis.selectOne("MessageDAO3.getMsg", vo);
		//selectOne의 리턴 타입이 MessageVO가 아니기 때문에 CASTING해준다.
	}
	
	public List<MessageVO> getMsgList(MessageVO vo){
	    System.out.println("메세지 목록 불러오기 mabatis");
	    return mybatis.selectList("MessageDAO3.getMsgList", vo);
	}
	
	
	
	
}
