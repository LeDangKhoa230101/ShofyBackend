package com.shofy.ShofyEcommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Cart;
import com.shofy.ShofyEcommerce.entity.Product;
import com.shofy.ShofyEcommerce.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	List<Cart> findAllByUser(User user);

	Optional<Cart> findByProduct(Product product);
	    
	Optional<Cart> findById(Long id);
	 
	void deleteAllByUser(User user);
	
}
