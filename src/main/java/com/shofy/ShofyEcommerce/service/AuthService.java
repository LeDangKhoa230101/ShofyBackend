package com.shofy.ShofyEcommerce.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.ReqResDto;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JWTUtils jwtUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public ReqResDto signUp(ReqResDto registrationRequest) {
		ReqResDto resDto = new ReqResDto();
		try {
			User user = new User();
			user.setName(registrationRequest.getName());
			user.setEmail(registrationRequest.getEmail());
			user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
			user.setRole("USER"); 
			User userResult = userRepository.save(user);
			if(userResult != null) {
				resDto.setUser(userResult);
				resDto.setMessage("User Saved Successfully");
				resDto.setStatusCode(200);
			} 
		} catch (Exception e) {
			resDto.setStatusCode(500);
			resDto.setError(e.getMessage()); 
		}
		return resDto;
	}
	
	public ReqResDto signin(ReqResDto signinRequest) {
		ReqResDto response = new ReqResDto();
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
			var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow();
			var jwt = jwtUtils.generateToken(user);
			var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
			response.setName(user.getName());			
			response.setStatusCode(200);
			response.setToken(jwt); 
			response.setRefreshToken(refreshToken);
			response.setExpirationTime("24Hr");
			response.setMessage("Successfully Signed In"); 
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setError(e.getMessage()); 
		}
		return response;
	}
	
	public ReqResDto refreshToken(ReqResDto refreshTokenRequest) {
		ReqResDto response = new ReqResDto();
		String email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
		User users = userRepository.findByEmail(email).orElseThrow();
		if(jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
			var jwt = jwtUtils.generateToken(users);
			response.setStatusCode(200);
			response.setToken(jwt); 
			response.setRefreshToken(refreshTokenRequest.getRefreshToken());
			response.setExpirationTime("24Hr"); 
			response.setMessage("Successfully Refreshed Token"); 
		}
		response.setStatusCode(500);
		return response;
	}

}















