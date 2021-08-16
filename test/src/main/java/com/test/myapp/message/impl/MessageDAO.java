package com.test.myapp.message.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.myapp.common.JDBC;
import com.test.myapp.message.MessageVO;

@Repository("messageDAO")
public class MessageDAO {
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	private ResultSet rs;
	
//	public void insertMessage(MessageVO vo);
//	public void deleteMessage(MessageVO vo);
//	public void updateMessage(MessageVO vo);
//	public MessageVO getMsg(MessageVO vo);
//	public List<MessageVO>getMsgList(MessageVO vo);

	public void InsertMessage(MessageVO vo) {
		conn=JDBC.getconntection();
		System.out.println("메세지 삽입");		
		String sql="insert into message (mid,writer,content) values((select nvl(max(mid),0)+1 from message),?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	public void DeleteMessage(MessageVO vo) {
		conn=JDBC.getconntection();
		System.out.println("메세지 삭제 dao");
		String sql="delete from message where mid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
			
		}
		
		
	}
	
	public void UpdateMessage(MessageVO vo) {
		
		System.out.println("메세지 업데이트 dao");
		conn=JDBC.getconntection();
		String sql="update message set content=? where mid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getMid());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
	}
//	public List<MessageVO>getMsgList(MessageVO vo);
	
	public MessageVO getMsg(MessageVO vo) {
		System.out.println("유저 정보 가져오기");
		conn=JDBC.getconntection();
		String sql="select * from message where mid=?";
		MessageVO data=null;//작업물 없으면 null이 들어간다. 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MessageVO();
				data.setMid(rs.getInt("mid"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	
		return data;
	}
	
	public List<MessageVO> getMsgList(MessageVO vo){
//		String sql="select * from message order by mid desc";
//		String sql2="select * from message order by mid desc";
		String sql="select * from message where writer like '%'||?||'%' order by mid desc";			
	    String sql2="select * from message where content like '%'||?||'%' order by mid desc";	
		conn=JDBC.getconntection();
		System.out.println("메세지 목록 불러오기 dao");
		List<MessageVO> datas=new ArrayList();
		try {
			
			if(vo.getSearch().equals("writer")) {
				pstmt=conn.prepareStatement(sql);				
			}
			else {
				pstmt=conn.prepareStatement(sql2);
			}
			pstmt.setString(1, vo.getSearchContent());//sql문에 있는 ?한개 의미 
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MessageVO data=new MessageVO();
				data.setMid(rs.getInt("mid"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	
		return datas;
		
	}
	public int getNext() {
		
		String sql="SELECT mid FROM message ORDER BY midDESC";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1; //현재 날짜 그대로 반환
			}
			return 1; //첫 번째 게시물인 경우 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류 
	}
	
	public boolean nextPage(int pageNumber) {

		String sql="SELECT * FROM MESSAGE WHERE mid < ? order by mid desc limit 10 ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false; //데이터 베이스 오류 
	}
	
	
	
	
}
