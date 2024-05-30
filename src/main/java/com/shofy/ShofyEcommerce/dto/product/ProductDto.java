package com.shofy.ShofyEcommerce.dto.product;

public class ProductDto {
	private Long id;
	private String name;
	private double priceOld;
	private double priceNew;
	private String imageDefault;
	private String cateName;

	public ProductDto() {
		super();
	}

	public ProductDto(Long id, String name, double priceOld, double priceNew, String imageDefault, String cateName) {
		super();
		this.id = id;
		this.name = name;
		this.priceOld = priceOld;
		this.priceNew = priceNew;
		this.imageDefault = imageDefault;
		this.cateName = cateName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(double priceOld) {
		this.priceOld = priceOld;
	}

	public double getPriceNew() {
		return priceNew;
	}

	public void setPriceNew(double priceNew) {
		this.priceNew = priceNew;
	}

	public String getImageDefault() {
		return imageDefault;
	}

	public void setImageDefault(String imageDefault) {
		this.imageDefault = imageDefault;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}
