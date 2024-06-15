package com.shofy.ShofyEcommerce.dto.wishlist;

import java.util.List;

public class WishlistDtos {

	private List<WishlistItemDto> wishlists;

	public WishlistDtos() {
		super();
	}

	public WishlistDtos(List<WishlistItemDto> wishlists) {
		super();
		this.wishlists = wishlists;
	}

	public List<WishlistItemDto> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<WishlistItemDto> wishlists) {
		this.wishlists = wishlists;
	}

}
