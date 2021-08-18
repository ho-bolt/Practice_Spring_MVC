package com.test.myapp.message.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.member.MemberVO;
import com.test.myapp.message.MessageVO;
@Repository("messageDAO3")
public class MessageDAO3 extends SqlSessionDaoSupport{
	//applicationContext.xml에 bean으로 만들어 놓았기 때문에 @autowired로 주입가능하고 
			//sqlsessiondaoSupport를 상속받아 거기에 있는 setSqlSessionFactory를 사용하겠다. 
	//따라서 mybatis.insert라고 되어 있던게 아래처럼 바뀐다.
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void InsertMessage(MessageVO vo) {
		System.out.println("메세지 삽입 mabatis");
		getSqlSession().insert("MessageDAO3.insertMessage", vo);
	}
	public void DeleteMessage(MessageVO vo) {
		System.out.println("메세지 삭제 mabatis");
		getSqlSession().delete("MessageDAO3.deleteMessage", vo);
	}
	
	public void UpdateMessage(MessageVO vo) {
		
		System.out.println("메세지 수정 mabatis");
		getSqlSession().update("MessageDAO3.updateMessage", vo);
		
	}
	public void UpdateMyPage(MemberVO vo) {
		System.out.println("마이페이지 수정 mabatis");
		getSqlSession().update("MessageDAO3.updateMyPage",vo);
	}
	
	public MessageVO getMsg(MessageVO vo) {
		System.out.println("유저 정보 가져오기 mabatis");
		
		return (MessageVO)getSqlSession().selectOne("MessageDAO3.getMsg", vo);
		//selectOne의 리턴 타입이 MessageVO가 아니기 때문에 CASTING해준다.
	}
	
	public List<MessageVO> getMsgList(MessageVO vo){
	    System.out.println("메세지 목록 불러오기 mabatis"); 
	    	return getSqlSession().selectList("MessageDAO3.getMsgList", vo);
	    }
	}
	
	
	
