package com.test.app.member.impl;

import com.test.app.member.MemberVO;

public class MemberServiceImpl {
	
	private MemberDAO memberDAO;
	
	public void Join(MemberVO vo) {
		memberDAO.Join(vo);
	}
	
	
	public MemberVO Login(MemberVO vo) {
		return memberDAO.Login(vo);
	}
	
}
