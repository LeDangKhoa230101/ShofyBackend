package com.shofy.ShofyEcommerce.dto;

public class ColorDto {
	private Long colorId;
	private String color;

	public ColorDto() {
		super();
	}

	public ColorDto(Long colorId, String color) {
		super();
		this.colorId = colorId;
		this.color = color;
	}

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
