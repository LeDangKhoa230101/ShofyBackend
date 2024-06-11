package com.shofy.ShofyEcommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Cart;
import com.shofy.ShofyEcommerce.entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	
	Optional<Cart> findByProduct(Product product);
	
}
