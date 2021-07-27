package com.test.myapp.member;

public class MemberVO {
// 	id varchar(30) primary key,
// 	password varchar(30),
// 	name varchar(30)
	
	private String id;
	private String password;
	private String name;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id +": "+this.name+"님 ";
	}
	
	
}
