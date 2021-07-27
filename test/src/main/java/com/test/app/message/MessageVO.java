package com.test.app.message;

public class MessageVO {


	private String mid;
	private String writer;
	private String content;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return this.mid+"님의 이름은"+this.mid+"이고 내용은"+this.content+"이다";
	}
}
