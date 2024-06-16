package com.shofy.ShofyEcommerce.dto;

import java.util.List;

import com.shofy.ShofyEcommerce.dto.cart.CartItemDto;

public class OrderDto {
	private List<CartItemDto> cartItems;
	private double totalPrice;
	private String phone;
	private String address;
	private String note;

	public OrderDto() {
		super();
	}

	public OrderDto(List<CartItemDto> cartItems, double totalPrice, String phone, String address, String note) {
		super();
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.phone = phone;
		this.address = address;
		this.note = note;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
