package com.event.management.event.dto.response;

public class CommonResponse {
	
	private String statusCode;
	private String message;
	
	public CommonResponse() {
		
	}
	
	public CommonResponse(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
