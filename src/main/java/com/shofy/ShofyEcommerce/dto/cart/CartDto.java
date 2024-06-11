package com.shofy.ShofyEcommerce.dto.cart;

import java.util.List;

public class CartDto {
	private List<CartItemDto> carts;
	private double totalPrice;

	public CartDto() {
		super();
	}

	public List<CartItemDto> getCarts() {
		return carts;
	}

	public void setCarts(List<CartItemDto> carts) {
		this.carts = carts;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
