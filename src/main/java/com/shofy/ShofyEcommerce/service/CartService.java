package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.cart.CartDto;
import com.shofy.ShofyEcommerce.dto.cart.CartItemDto;
import com.shofy.ShofyEcommerce.entity.Cart;
import com.shofy.ShofyEcommerce.entity.Product;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.exceptions.CartException;
import com.shofy.ShofyEcommerce.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductService productService;
	
	public ResponseEntity<ApiResponseDto> addToCart(Integer quantity, Long productId, User user) {
		Product product = productService.findById(productId);
		
		if(product == null) {
			throw new CartException("Product is not valid" + user.getEmail());
		}
		
		Optional<Cart> existCart = cartRepository.findByProduct(product);
		
		if(existCart.isPresent()) {
			// Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
			Cart cart = existCart.get();
			cart.setQuantity(cart.getQuantity() + quantity);
			cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
			cart.setCreateAt(new Date());
			cartRepository.save(cart);
		} else {
			// Nếu sản phẩm chưa tồn tại trong giỏ hàng, tạo một mục mới
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(quantity);
			cart.setUser(user);
			cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
			cart.setCreateAt(new Date());
			cartRepository.save(cart);
		}
		
		return new ResponseEntity<>(new ApiResponseDto("Success", "Added cart successful"), HttpStatus.CREATED);
	}
	
	public CartDto getListCartItems(User user) {
		List<Cart> cartList = cartRepository.findAllByUser(user);
		
		List<CartItemDto> cartItems = new ArrayList<CartItemDto>();
		
		double totalPrice = 0;
		
		for(Cart cart : cartList) {
			CartItemDto cartItemDto = new CartItemDto(cart);
			totalPrice += cartItemDto.getQuanty() * cartItemDto.getProductPriceNew();
			cartItems.add(cartItemDto); 
		}
		
		CartDto cartDto = new CartDto();
		cartDto.setCartItems(cartItems);
		cartDto.setTotalPrice(totalPrice);
		
		return cartDto;
	}
	
	public ResponseEntity<ApiResponseDto> removeItemCart(Long id, User user) {
		Optional<Cart> cart = cartRepository.findById(id);
		if(cart.get() == null) {
			throw new CartException("Cart không hợp lệ" + id);
		}
		
		if(cart.get().getUser() != user) {
			throw new CartException("Cart không thuộc user" + user.getEmail());
		}
		
		cartRepository.delete(cart.get());
		
		return new ResponseEntity<>(new ApiResponseDto("Success", "Remove cart success"), HttpStatus.OK);
		
	}
	
	@Transactional
	public void clearCart(User user) {
		cartRepository.deleteAllByUser(user);
	}
	
	public void updateCartPlus(Long id, User user) {
		Optional<Cart> optionalCart = cartRepository.findById(id);
		
		if(optionalCart.get() == null) {
			throw new CartException("Cart không hợp lệ" + id);
		}
		
		if(optionalCart.get().getUser() != user) {
			throw new CartException("Cart không thuộc user" + user.getEmail());
		}
		
		Cart cart = optionalCart.get();
		cart.setQuantity(cart.getQuantity() + 1);
		cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
		
		cartRepository.save(cart);
	}
	
	public void updateCartMinus(Long id, User user) {
		Optional<Cart> optionalCart = cartRepository.findById(id);
		
		if(optionalCart.get() == null) {
			throw new CartException("Cart không hợp lệ" + id);
		}
		
		if(optionalCart.get().getUser() != user) {
			throw new CartException("Cart không thuộc user" + user.getEmail());
		}
		
		Cart cart = optionalCart.get();
		cart.setQuantity(cart.getQuantity() - 1);
		cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
		
		cartRepository.save(cart);
	}
	
	public int countCart(User user) {
		List<Cart> cartList = cartRepository.findAllByUser(user);
		
		return cartList.size();
		
	}
	
}
