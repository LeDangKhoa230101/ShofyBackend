package com.shofy.ShofyEcommerce.dto.cart;

import java.util.List;

public class CartDto {
	private List<CartItemDto> cartItems;
	private double totalPrice;

	public CartDto() {
		super();
	}

	public List<CartItemDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
