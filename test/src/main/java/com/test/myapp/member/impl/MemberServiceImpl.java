package com.test.myapp.member.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myapp.member.MemberService;
import com.test.myapp.member.MemberVO;
@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO3 memberDAO;
	

	public void insert(MemberVO vo) {
		memberDAO.insertMember(vo);
	}	
	
	
	public MemberVO Login(MemberVO vo) {
		return memberDAO.Login(vo);
	}






	
}
