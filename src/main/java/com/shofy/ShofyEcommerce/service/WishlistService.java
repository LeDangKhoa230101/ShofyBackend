package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.ApiResponseDto;
import com.shofy.ShofyEcommerce.dto.wishlist.WishlistDtos;
import com.shofy.ShofyEcommerce.dto.wishlist.WishlistItemDto;
import com.shofy.ShofyEcommerce.entity.Product;
import com.shofy.ShofyEcommerce.entity.User;
import com.shofy.ShofyEcommerce.entity.Wishlist;
import com.shofy.ShofyEcommerce.repository.WishlistRepository;

@Service
public class WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private ProductService productService;
	
	public ApiResponseDto addWishlist(Long productId, User user) {
		Product product = productService.findById(productId);
		
		Wishlist wishlistByProduct = wishlistRepository.findByProduct(product);
		
		// product ko tồn tại trong wishlist
		if(wishlistByProduct == null) {
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			wishlist.setProduct(product);
			wishlist.setCreatedAt(new Date());
			wishlistRepository.save(wishlist);
		} else {
			return new ApiResponseDto("Failed", "Add wishlist failed");
		}
		
		return new ApiResponseDto("Success", "Add wishlist successful");
	}
	
	public WishlistDtos getWishlists(User user) {
		List<Wishlist> wishlistList = wishlistRepository.findAllByUser(user);
		
		List<WishlistItemDto> wishlistItemDtos = new ArrayList<WishlistItemDto>();
		
		for(Wishlist wishlist : wishlistList) {
			WishlistItemDto wishlistItemDto = new WishlistItemDto(wishlist);
			wishlistItemDtos.add(wishlistItemDto);
		}
		
		WishlistDtos wishlistDtos = new WishlistDtos();
		wishlistDtos.setWishlists(wishlistItemDtos);
		
		return wishlistDtos;
	}
	
	public ApiResponseDto removeWishlist(Long id, User user) {
		Optional<Wishlist> wishlist = wishlistRepository.findById(id);
		
		if(wishlist.get().getUser() == user) {
			wishlistRepository.delete(wishlist.get());
		}
		
		return new ApiResponseDto("Success", "Remove wishlist success");
		
	}
	
	public int countWishlist(User user) {
		List<Wishlist> wishlists = wishlistRepository.findAllByUser(user);
		
		return wishlists.size();
		
	}
	
}
