package com.example.SpringBoot_Projectcom.example.SpringBoot_Project.repository.dtp;

public class ResponseStructure <T> {
	
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	private int StatusCode;
	private String message;
	private T data;

}
