package com.curso.socialbooks.domain;

public class DetailError {
	
	private String title;
	private Long Status;
	private Long timestamp;
	private String developermessage;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getStatus() {
		return Status;
	}
	public void setStatus(Long status) {
		Status = status;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDevelopermessage() {
		return developermessage;
	}
	public void setDevelopermessage(String developermessage) {
		this.developermessage = developermessage;
	}
	
	
	

}
