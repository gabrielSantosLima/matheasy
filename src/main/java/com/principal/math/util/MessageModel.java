package com.principal.math.util;

import java.util.Calendar;

import ch.qos.logback.core.util.LocationUtil;

public class MessageModel {

	private String content;
	private String time;
	private String from;
	private Integer userId;
	
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
