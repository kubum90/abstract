package com.hanbit.board.domain;

public class BoardBean {
	private String writer,title,content,regdate;
	private int seq;
	
	public void setWriter(String writer){
		this.writer=writer;
	}
	public String getWriter(){
		return writer;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setRegDate(String regdate){
		this.regdate=regdate;
	}
	public String getRegDate(){
		return regdate;
	}
	public void setSeq(int seq){
		this.seq=seq;
	}
	public int getSeq(){
		return seq;
	}
	public String toString(){
		return String.format("seq::%d writer::%s title::%s content::%s RegDate::%s",seq,writer,title,content,regdate);
	}
}
