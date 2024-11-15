package com.example.demo.payload;

import java.time.LocalDateTime;


public class ErrorResponse {

	private String HttpResposne;
	
	private String message;
	
	private String exceptionMessage;
	
	private LocalDateTime timestamp;

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String httpResposne, String message, String exceptionMessage) {
		super();
		HttpResposne = httpResposne;
		this.message = message;
		this.exceptionMessage = exceptionMessage;
		this.timestamp = LocalDateTime.now();
	}

	public String getHttpResposne() {
		return HttpResposne;
	}

	public void setHttpResposne(String httpResposne) {
		HttpResposne = httpResposne;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponse [HttpResposne=" + HttpResposne + ", message=" + message + ", exceptionMessage="
				+ exceptionMessage + ", timestamp=" + timestamp + "]";
	}
	
	
	
	
	
}
