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
		System.out.println("메세지 삽입");		
		String sql="insert into message (mid,writer,content) values((select nvl(max(mid),0)+1 from message),?,?)";
			jdbctemplate.update(sql,vo.getMid(),vo.getWriter(),vo.getContent());
	}
	public void DeleteMessage(MessageVO vo) {
		System.out.println("메세지 삭제 dao");
		String sql="delete from message where mid=?";
		jdbctemplate.update(sql,vo.getMid());
		
	}
	
	public void UpdateMessage(MessageVO vo) {
		
		System.out.println("메세지 업데이트 dao");
		String sql="update message set content=? where mid=?";
		jdbctemplate.update(sql,vo.getMid(),vo.getContent());
		
		
	}
//	public List<MessageVO>getMsgList(MessageVO vo);
	
	public MessageVO getMsg(MessageVO vo) {
		System.out.println("유저 정보 가져오기");
		String sql="select * from message where mid=?";
		MessageVO data=null;//작업물 없으면 null이 들어간다. 
		Object [] args= {vo.getMid()};
		
		return jdbctemplate.queryForObject(sql, args,new MessageRowMapper());
	}
	
	public List<MessageVO> getMsgList(MessageVO vo){
		String sql="select * from message order by mid desc";
		System.out.println("메세지 목록 불러오기 dao");
		List<MessageVO> datas=new ArrayList();
		Object []args= {vo.getMid()};
		
		return (List<MessageVO>) jdbctemplate.queryForObject(sql, args,new MessageRowMapper());
		
	}
	
	class MessageRowMapper implements RowMapper<MessageVO>{
		public MessageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MessageVO data=new MessageVO();
			data.setMid(rs.getInt("mid"));
			data.setWriter(rs.getString("writer"));
			data.setContent(rs.getString("content"));
		
			return data;
		}
	}
	
	
}
