package com.shofy.ShofyEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Token;
import com.shofy.ShofyEcommerce.entity.User;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
	
	Token findByUser(User user);
	
	Token findByToken(String token);
	
}
