package com.shofy.ShofyEcommerce.dto.product;

import java.util.List;

import com.shofy.ShofyEcommerce.entity.Color;
import com.shofy.ShofyEcommerce.entity.Image;

public class ProductDetailDto {
	private String name;
	private double priceOld;
	private double priceNew;
	private String description;
	private String imageDefault;
	private String cateName;
	private String brandName;
	private boolean productNew;
	private boolean productFeatured;
	private boolean productSeller;
	private List<Color> colors;
	private List<Image> images;

	public ProductDetailDto() {
		super();
	}

	public ProductDetailDto(String name, double priceOld, double priceNew, String description, String imageDefault,
			String cateName, String brandName, boolean productNew, boolean productFeatured, boolean productSeller,
			List<Color> colors, List<Image> images) {
		super();
		this.name = name;
		this.priceOld = priceOld;
		this.priceNew = priceNew;
		this.description = description;
		this.imageDefault = imageDefault;
		this.cateName = cateName;
		this.brandName = brandName;
		this.productNew = productNew;
		this.productFeatured = productFeatured;
		this.productSeller = productSeller;
		this.colors = colors;
		this.images = images;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isProductNew() {
		return productNew;
	}

	public void setProductNew(boolean productNew) {
		this.productNew = productNew;
	}

	public boolean isProductFeatured() {
		return productFeatured;
	}

	public void setProductFeatured(boolean productFeatured) {
		this.productFeatured = productFeatured;
	}

	public boolean isProductSeller() {
		return productSeller;
	}

	public void setProductSeller(boolean productSeller) {
		this.productSeller = productSeller;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
