package com.test.myapp.member.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.myapp.common.JDBC;
import com.test.myapp.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public void InsertMember(MemberVO vo) {
		System.out.println("회원가입 jdbcTemplate dao");
		String sql="insert into member (id,password,name,role) values(?,?,?,?)";
		conn=JDBC.getconntection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId() );
			pstmt.setString(2,vo.getPassword() );
			pstmt.setString(3,vo.getName() );
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
//		System.out.println(jdbcTemplate);
//		String sql="insert into member (id,password,name,role) values(?,?,?,?)";
//		jdbcTemplate.update(sql,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	
	public MemberVO Login(MemberVO vo) {
			
		String sql="select * from member where id=? and password=?";
		System.out.println("로그인 jdbcTemplate dao");
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
				data.setPassword(rs.getString("password"));
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
//		System.out.println(jdbcTemplate);
//		Object[] args= {vo.getId(),vo.getPassword()};
//		
//		return jdbcTemplate.queryForObject(sql,args,new MemberRowMapper());
	}
	
	
	class MemberRowMapper implements RowMapper{

		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO data=new MemberVO();
			data.setId(rs.getString("id"));
			data.setPassword(rs.getString("password"));
			data.setName(rs.getString("name"));
			data.setRole(rs.getString("role"));		
			return data;
		}
		
	}

		
	
	
	

