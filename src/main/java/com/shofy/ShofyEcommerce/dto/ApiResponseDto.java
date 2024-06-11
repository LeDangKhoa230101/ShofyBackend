package com.shofy.ShofyEcommerce.dto;

public class ApiResponseDto {
	private String status;
	private String message;

	public ApiResponseDto(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ApiResponseDto() {
		super();
	}

	public String isStatus() {
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

}
