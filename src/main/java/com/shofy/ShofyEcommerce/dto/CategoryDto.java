package com.shofy.ShofyEcommerce.dto;

public class CategoryDto {
	private String cateName;
	private String cateImage;
	private Long productCount;

	public CategoryDto() {
		super();
	}

	public CategoryDto(String cateName, String cateImage, Long productCount) {
		this.cateName = cateName;
		this.cateImage = cateImage;
		this.productCount = productCount;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateImage() {
		return cateImage;
	}

	public void setCateImage(String cateImage) {
		this.cateImage = cateImage;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

}
