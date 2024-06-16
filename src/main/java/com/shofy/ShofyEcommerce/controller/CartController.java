package com.shofy.ShofyEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.OrderDto;
import com.shofy.ShofyEcommerce.dto.cart.CartDto;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.service.CartService;
import com.shofy.ShofyEcommerce.service.OrderService;
import com.shofy.ShofyEcommerce.service.TokenService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add-to-cart/{productId}")
	public ResponseEntity<ApiResponseDto> addToCart(
			@PathVariable("productId") Long productId, 
			@RequestParam Integer quantity, @RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return cartService.addToCart(quantity, productId, user);
		
	}
	
	@PostMapping("/remove/{id}")
	public ResponseEntity<ApiResponseDto> removeItem(
			@PathVariable("id") Long id, @RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return cartService.removeItemCart(id, user);
	}
	
	@PostMapping("/remove-all")
	public void removeAll(@RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		cartService.clearCart(user);
		
	}
	
	@PostMapping("/plus-cart/{id}")
	public void plusCart(@PathVariable("id") Long id, @RequestParam("token") String token) {
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		cartService.updateCartPlus(id, user);
	}
	
	@PostMapping("/minus-cart/{id}")
	public void minusCart(@PathVariable("id") Long id, @RequestParam("token") String token) {
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		cartService.updateCartMinus(id, user);
	}
	
	@GetMapping("/")
	public ResponseEntity<CartDto> listCart(@RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		CartDto cartDto = cartService.getListCartItems(user);
		
		return new ResponseEntity<>(cartDto, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public int countCart(@RequestParam("token") String token) {
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		return cartService.countCart(user);
	}
	
	@PostMapping("/checkout")
	public OrderDto checkout(@RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("note") String note,
			@RequestParam("token") String token) {
		
		tokenService.authenticate(token);
		User user = tokenService.getUser(token);
		
		return orderService.checkout(phone, address, note, user);
		
	}
	
}
