package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.app.common.JDBC;
import com.test.app.member.MemberVO;

public class MemberDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	public void Join(MemberVO vo) {
		
		String sql="insert into member (id,passward,name) values(?,?,?,'USER')";
		System.out.println("회원가입중");
		conn=JDBC.getconntection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId() );
			pstmt.setString(2,vo.getPassword() );
			pstmt.setString(3,vo.getName() );
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	
	public MemberVO Login(MemberVO vo) {
			
		String sql="select * from member where id=? and passward=?";
		System.out.println("로그인하기");
		MemberVO data=null;
		conn=JDBC.getconntection();
		
		try {
			data=new MemberVO();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("passward"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		return data;
	}
	
	
	
}
