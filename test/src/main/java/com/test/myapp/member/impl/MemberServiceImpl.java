package com.test.myapp.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myapp.member.MemberService;
import com.test.myapp.member.MemberVO;
@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	

	public void insert(MemberVO vo) {
		memberDAO.InsertMember(vo);
	}	
	
	
	public MemberVO Login(MemberVO vo) {
		return memberDAO.Login(vo);
	}
	
}
