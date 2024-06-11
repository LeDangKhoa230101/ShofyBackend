package com.shofy.ShofyEcommerce.dto.cart;

import com.shofy.ShofyEcommerce.entity.Product;

public class CartItemDto {
	private Long id;
	private double price;
	private int quanty;
	private Product product;

	public CartItemDto() {
		super();
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

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
