package com.shofy.ShofyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.wishlist.WishlistDtos;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.service.TokenService;
import com.shofy.ShofyEcommerce.service.WishlistService;

@RestController
@RequestMapping("wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/add-wishlist/{productId}")
	public ApiResponseDto addWishlist(
			@PathVariable("productId") Long productId, 
			@RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return wishlistService.addWishlist(productId, user); 
	}
	
	@PostMapping("/remove-wishlist/{id}")
	public ApiResponseDto removeWishlist(
			@PathVariable("id") Long id, 
			@RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return wishlistService.removeWishlist(id, user);
	}
	
	@GetMapping("/")
	public WishlistDtos getWishlists(@RequestParam("token") String token) {
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return wishlistService.getWishlists(user); 
	}
	
	@GetMapping("/count-wishlist")
	public int getCountWishlists(@RequestParam("token") String token) {
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return wishlistService.countWishlist(user); 
	}
	
}
