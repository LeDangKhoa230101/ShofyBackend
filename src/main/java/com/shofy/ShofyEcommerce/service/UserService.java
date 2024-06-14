package com.shofy.ShofyEcommerce.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.user.SignInDto;
import com.shofy.ShofyEcommerce.dto.user.SignInResponseDto;
import com.shofy.ShofyEcommerce.dto.user.SignUpDto;
import com.shofy.ShofyEcommerce.entity.Token;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.exceptions.AuthenticationFailException;
import com.shofy.ShofyEcommerce.repository.TokenRepository;
import com.shofy.ShofyEcommerce.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private TokenRepository tokenRepository;

	@Transactional
	public ApiResponseDto signup(SignUpDto signUpDto) {
		// check user is exist
		User userExits = userRepository.findByEmail(signUpDto.getEmail());
		if (userExits != null) {
			throw new AuthenticationFailException("Người dùng đã tồn tại");
		}
		
		// hash password
		String encryptPassword = signUpDto.getPassword();
		try {
			encryptPassword = hashPassword(signUpDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		// save user
		User userSignUp = new User(signUpDto.getName(), signUpDto.getEmail(), encryptPassword, "ROLE_ADMIN");
		userRepository.save(userSignUp);
		
		// create token
		final Token token = new Token(userSignUp);
		tokenService.saveConfirmationToken(token);
		
		return new ApiResponseDto("Success", "User created Successful");
	}
	
	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}
	
	// signin
	public SignInResponseDto signin(SignInDto signInDto) {
		
		// check user
		User user = userRepository.findByEmail(signInDto.getEmail());
		if(user == null) {
			throw new AuthenticationFailException("Người dùng không tồn tại");
		}
		 
		// hash password
		try {
			if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				throw new AuthenticationFailException("Sai mật khẩu");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// if password not wrong
		Token token = tokenService.getToken(user);
		if(token == null) {
			// create token
			final Token newToken = new Token(user);
			tokenService.saveConfirmationToken(newToken); 
		}
		
		return new SignInResponseDto("Success", token.getToken(), user.getRole(), user.getName());
		
	}
	
	public ApiResponseDto signout(String token) {
		Token authenToken = tokenRepository.findByToken(token);
		if(authenToken != null) {
			tokenRepository.delete(authenToken);
			return new ApiResponseDto("Success", "Signout successful");
		}
		return new ApiResponseDto("Failed", "Signout failed");
	}
	
}
