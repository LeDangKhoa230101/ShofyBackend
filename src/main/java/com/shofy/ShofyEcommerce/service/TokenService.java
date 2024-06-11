package com.shofy.ShofyEcommerce.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.entity.Token;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public void saveConfirmationToken(Token token) {
		tokenRepository.save(token);
	}

	public Token getToken(User user) {
		return tokenRepository.findByUser(user);
	}

	public User getUser(String token) {
		final Token authenticationToken = tokenRepository.findByToken(token);
		if (Objects.isNull(authenticationToken)) {
			return null;
		}
		// authenticationToken is not null
		return authenticationToken.getUser();
	}

//	public void authenticate(String token) throws AuthenticationFailException {
//		// null check
//		if (Objects.isNull(token)) {
//			// throw an exception
//			throw new AuthenticationFailException("token not present");
//		}
//		if (Objects.isNull(getUser(token))) {
//			throw new AuthenticationFailException("token not valid");
//		}
//	}

}
