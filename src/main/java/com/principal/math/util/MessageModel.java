package com.principal.math.util;

import java.util.Calendar;

public class MessageModel {

	private String content;
	private String time;
	private String from;
	private Integer userId;
	
	public MessageModel(String content, String time, String from, Integer userId) {
		this.content = content;
		this.time = time;
		this.from = from;
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	public void setDateToTime() {
		this.time = Calendar.getInstance().getTime().toString();
	}
}
