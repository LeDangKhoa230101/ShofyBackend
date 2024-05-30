package com.shofy.ShofyEcommerce.dto.product;

import java.util.List;

import com.shofy.ShofyEcommerce.dto.ColorDto;
import com.shofy.ShofyEcommerce.dto.ImageDto;

public class ProductDetailDto {
	private String name;
	private double priceOld;
	private double priceNew;
	private String description;
	private String imageDefault;
	private String cateName;
	private String brandName;
	private List<ColorDto> colors;
	private List<ImageDto> images;

	public ProductDetailDto() {
		super();
	}

	public ProductDetailDto(String name, double priceOld, double priceNew, String description, String imageDefault,
			String cateName, String brandName, List<ColorDto> colors, List<ImageDto> images) {
		super();
		this.name = name;
		this.priceOld = priceOld;
		this.priceNew = priceNew;
		this.description = description;
		this.imageDefault = imageDefault;
		this.cateName = cateName;
		this.brandName = brandName;
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

	public List<ColorDto> getColors() {
		return colors;
	}

	public void setColors(List<ColorDto> colors) {
		this.colors = colors;
	}

	public List<ImageDto> getImages() {
		return images;
	}

	public void setImages(List<ImageDto> images) {
		this.images = images;
	}

}
