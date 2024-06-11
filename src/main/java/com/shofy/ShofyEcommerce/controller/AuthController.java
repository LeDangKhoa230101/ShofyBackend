package com.shofy.ShofyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.user.SignInDto;
import com.shofy.ShofyEcommerce.dto.user.SignInResponseDto;
import com.shofy.ShofyEcommerce.dto.user.SignUpDto;
import com.shofy.ShofyEcommerce.exceptions.AuthenticationFailException;
import com.shofy.ShofyEcommerce.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody SignUpDto signUpDto) {
		try {
			ApiResponseDto response = userService.signup(signUpDto);
			return ResponseEntity.ok(response);
		} catch (AuthenticationFailException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody SignInDto signInDto) {
		try {
			SignInResponseDto response = userService.signin(signInDto);
			return ResponseEntity.ok(response);
		} catch (AuthenticationFailException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
		}
	} 
	
}
