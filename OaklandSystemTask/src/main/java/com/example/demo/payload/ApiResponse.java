package com.example.demo.payload;

public class ApiResponse <T> {
	
	private String  HttpStatus;
	
	private String status;
	
	private String message;
	
	private T data;

	
	
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ApiResponse(String httpStatus, String status, String message, T data) {
		super();
		HttpStatus = httpStatus;
		this.status = status;
		this.message = message;
		this.data = data;
	}



	public String getHttpStatus() {
		return HttpStatus;
	}



	public void setHttpStatus(String httpStatus) {
		HttpStatus = httpStatus;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
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



	@Override
	public String toString() {
		return "ApiResponse [HttpStatus=" + HttpStatus + ", status=" + status + ", message=" + message + ", data="
				+ data + "]";
	}
	
	
	
	
}
