package com.shofy.ShofyEcommerce.dto.wishlist;

import com.shofy.ShofyEcommerce.entity.Wishlist;

public class WishlistItemDto {
	private Long wishlistId;
	private Long productId;
	private String productName;
	private String productImageDefault;
	private double productPriceNew;

	public WishlistItemDto() {
		super();
	}

	public WishlistItemDto(Wishlist wishlist) {
		this.wishlistId = wishlist.getId();
		this.productId = wishlist.getProduct().getId();
		this.productName = wishlist.getProduct().getName();
		this.productImageDefault = wishlist.getProduct().getImageDefault();
		this.productPriceNew = wishlist.getProduct().getPriceNew();
	}

	public Long getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Long wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageDefault() {
		return productImageDefault;
	}

	public void setProductImageDefault(String productImageDefault) {
		this.productImageDefault = productImageDefault;
	}

	public double getProductPriceNew() {
		return productPriceNew;
	}

	public void setProductPriceNew(double productPriceNew) {
		this.productPriceNew = productPriceNew;
	}

}
