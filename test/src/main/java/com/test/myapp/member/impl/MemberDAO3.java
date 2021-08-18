package com.test.myapp.member.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.myapp.member.MemberVO;
import com.test.myapp.message.MessageVO;
@Repository("memberDAO3")
public class MemberDAO3 extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insertMember(MemberVO vo) {
		System.out.println("회원가입 mybatis");
		getSqlSession().insert("MemberDAO3.insertMember", vo);
	}
	
	public MemberVO Login(MemberVO vo) {
		System.out.println("로그인 mybatis");
		return (MemberVO)getSqlSession().selectOne("MemberDAO3.login", vo);
		
	}
	
	
	
	
	
}
