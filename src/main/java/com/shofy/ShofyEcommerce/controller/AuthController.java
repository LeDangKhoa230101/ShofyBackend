package com.shofy.ShofyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.ReqResDto;
import com.shofy.ShofyEcommerce.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<ReqResDto> signUp(@RequestBody ReqResDto signUpRequest) {
		return ResponseEntity.ok(authService.signUp(signUpRequest));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<ReqResDto> signIn(@RequestBody ReqResDto signInRequest) {
		return ResponseEntity.ok(authService.signin(signInRequest));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<ReqResDto> refreshToken(@RequestBody ReqResDto refreshTokenRequest) {
		return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
	}
	
}
