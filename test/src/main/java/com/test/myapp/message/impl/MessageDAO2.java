package com.test.myapp.message.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.myapp.common.JDBC;
import com.test.myapp.message.MessageVO;

@Repository("messageDAO2")
public class MessageDAO2 {
		
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	public void InsertMessage(MessageVO vo) {
		System.out.println("메세지 삽입 jdbctemplate");		
		String sql="insert into message (mid,title,content) values((select nvl(max(mid),0)+1 from message),?,?)";
			jdbctemplate.update(sql,vo.getTitle(),vo.getContent());
	}
	public void DeleteMessage(MessageVO vo) {
		System.out.println("메세지 삭제 dao jdbctemplate");
		String sql="delete from message where mid=?";
		jdbctemplate.update(sql,vo.getMid());
		
	}
	
	public void UpdateMessage(MessageVO vo) {
		
		System.out.println("메세지 업데이트 dao jdbctemplate");
		String sql="update message set content=? where mid=?";
		jdbctemplate.update(sql,vo.getContent(),vo.getMid());
		
		
	}
//	public List<MessageVO>getMsgList(MessageVO vo);
	
	public MessageVO getMsg(MessageVO vo) {
		System.out.println("유저 정보 가져오기 jdbctemplate");
		String sql="select * from message where mid=?";
		MessageVO data=null;//작업물 없으면 null이 들어간다. 
		Object [] args= {vo.getMid()};
		
		return jdbctemplate.queryForObject(sql, args,new MessageRowMapper());
	}
	
	public List<MessageVO> getMsgList(MessageVO vo){
		String sql="select * from message where title like '%'||?||'%' order by mid desc";			
	    String sql2="select * from message where content like '%'||?||'%' order by mid desc";
		System.out.println("메세지 목록 불러오기 dao jdbctemplate");
		
		Object []args= {vo.getSearchContent()};
		
		if(vo.getSearch().equals("title")) {
			return jdbctemplate.query(sql, args,new MessageRowMapper());		
		}
		else {
			return jdbctemplate.query(sql2, args,new MessageRowMapper());	
		}
		
	}
	
	class MessageRowMapper implements RowMapper{
		public MessageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MessageVO data=new MessageVO();
			data.setMid(rs.getInt("mid"));
			data.setTitle(rs.getString("title"));
			data.setContent(rs.getString("content"));
		
			return data;
		}
	}
	
	
}
