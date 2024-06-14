package com.shofy.ShofyEcommerce.dto.cart;

import com.shofy.ShofyEcommerce.entity.Cart;

public class CartItemDto {
	private Long id;
	private double price;
	private Integer quanty;
	private Long productId;
	private String productName;
	private String productImageDefault;
	private double productPriceNew;

	public CartItemDto() {
		super();
	}

	public CartItemDto(Cart cart) {
		this.id = cart.getId();
		this.price = cart.getPrice();
		this.quanty = cart.getQuantity();
		this.productId = cart.getProduct().getId();
		this.productName = cart.getProduct().getName();
		this.productImageDefault = cart.getProduct().getImageDefault();
		this.productPriceNew = cart.getProduct().getPriceNew();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuanty() {
		return quanty;
	}

	public void setQuanty(Integer quanty) {
		this.quanty = quanty;
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
