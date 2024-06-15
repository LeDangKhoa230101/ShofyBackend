package com.shofy.ShofyEcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Product;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

	Wishlist findByProduct(Product product);
	
	List<Wishlist> findAllByUser(User user);
	
}
