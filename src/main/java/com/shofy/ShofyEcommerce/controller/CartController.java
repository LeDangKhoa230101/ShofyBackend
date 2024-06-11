package com.shofy.ShofyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
//	@PostMapping("/add-to-cart/{productId}")
//	public ResponseEntity<ApiResponseDto> addToCart(
//			@PathVariable("productId") Long productId, 
//			@RequestParam int quantity, @RequestBody ReqResDto requestToken) {
//		
//		return cartService.addToCart(quantity, productId, requestToken);
//		
//	}
	
}
