package com.shofy.ShofyEcommerce.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.entity.Cart;
import com.shofy.ShofyEcommerce.entity.Product;
import com.shofy.ShofyEcommerce.repository.CartRepository;
import com.shofy.ShofyEcommerce.repository.ProductRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
//	public ResponseEntity<ApiResponseDto> addToCart(int quantity, Long productId, ReqResDto requestToken) {
//		Optional<Product> product = productRepository.findById(productId);
//		
//		Optional<Cart> existCart = cartRepository.findByProduct(product.get());
//		
//		if(existCart.isPresent()) {
//			// Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
//			Cart cart = existCart.get();
//			cart.setQuantity(cart.getQuantity() + quantity);
//			cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
//			cart.setCreateAt(new Date());
//			cartRepository.save(cart);
//		} else {
//			// Nếu sản phẩm chưa tồn tại trong giỏ hàng, tạo một mục mới
//			Cart cart = new Cart();
//			cart.setProduct(product.get());
//			cart.setQuantity(quantity);
//			cart.setUser(requestToken.getUser());
//			cart.setPrice(cart.getQuantity() * cart.getProduct().getPriceNew());
//			cart.setCreateAt(new Date());
//			cartRepository.save(cart);
//		}
//		
//		return new ResponseEntity<>(new ApiResponseDto(true, "Added cart successful"), HttpStatus.CREATED);
//	}
	
}
