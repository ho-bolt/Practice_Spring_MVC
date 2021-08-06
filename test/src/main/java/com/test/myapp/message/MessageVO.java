package com.test.myapp.message;

import org.springframework.web.multipart.MultipartFile;

public class MessageVO {


	private int mid;
	private String writer;
	private String content;
	private String search;
	private String searchContent;
	//검색기능 수행시 컨테이너가 command객체를 생성, 생생된 객체에 값 추출 
	//만약,dao에서 @RequestParam을 사용하지 않는다면, 이걸로 넘길 수도 있다. 
	private MultipartFile uploadFile; //setter로 값을 넘길때, 인자로 전달할 uploadFile이 있어야 한다. 
	//즉 이 객체가 있어야 함으로, applicationContext.xml에서 객체를 만드는 데 재료가 필요하다!
	//그것은 pom.xml에서 만들어야 한다. 
	
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
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
		return this.mid+"님의 이름은"+this.writer+"이고 내용은"+this.content+"이다";
	}
}
