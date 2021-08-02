package com.test.myapp.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.myapp.common.JDBC;
import com.test.myapp.member.MemberVO;

@Repository("MemberDAO2")
public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void InsertMember(MemberVO vo) {
		System.out.println("회원가입 jdbcTemplate dao");
		String sql="insert into member (id,password,name,role) values(?,?,?,?)";
//		System.out.println(jdbcTemplate);
		jdbcTemplate.update(sql,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
	
	public MemberVO Login(MemberVO vo) {
			
		String sql="select * from member where id=? and password=?";
		System.out.println("로그인 jdbcTemplate dao");
		Object[] args= {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(sql,args, new MemberRowMapper());
	}
	
	
	
	class MemberRowMapper implements RowMapper{

		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO data=new MemberVO();
			data.setId(rs.getString("id"));
			data.setPassword(rs.getString("password"));
			data.setName(rs.getString("name"));
			data.setRole(rs.getString("role"));		
			return data;
		}
		
	}
	public void updateMember(MemberVO vo) {
		String sql="update member set password=?, where id=?";
		jdbcTemplate.update(sql,vo.getId(),vo.getPassword());
	}
	
	public void deleteMember(MemberVO vo) {
		String sql="delete member where id=?";
		jdbcTemplate.update(sql,vo.getId());
	}
	
	
}
