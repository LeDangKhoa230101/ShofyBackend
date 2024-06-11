package com.shofy.ShofyEcommerce.dto.user;

public class SignInResponseDto {
	private String status;
	private String token;
	private String role;
	private String name;

	public SignInResponseDto() {
		super();
	}

	public SignInResponseDto(String status, String token, String role, String name) {
		super();
		this.status = status;
		this.token = token;
		this.role = role;
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
