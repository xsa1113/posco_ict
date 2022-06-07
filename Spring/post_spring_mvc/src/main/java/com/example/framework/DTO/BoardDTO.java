package com.example.framework.DTO;

import java.util.Date;

public class BoardDTO {
	private Integer board_id;
	private String title;
	private String content;
	private String user;
	private Date insert_date;
	
	public BoardDTO() {
		
	}
	public BoardDTO(Integer board_id, String title, String content, String user, Date insert_date) {
		super();
		this.board_id = board_id;
		this.title = title;
		this.content = content;
		this.user = user;
		this.insert_date = insert_date;
	}
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	@Override
	public String toString() {
		return "BoardDTO [board_id=" + board_id + ", title=" + title + ", content=" + content + ", user=" + user
				+ ", insert_date=" + insert_date + "]";
	}
	
	
	
}
