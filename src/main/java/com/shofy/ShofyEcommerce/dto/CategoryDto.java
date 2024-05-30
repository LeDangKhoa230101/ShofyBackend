package com.shofy.ShofyEcommerce.dto;

public class CategoryDto {
	private Long cateId;
	private String cateName;
	private String cateImage;
	private Long productCount;

	public CategoryDto() {
		super();
	}

	public CategoryDto(Long cateId, String cateName, String cateImage, Long productCount) {
		this.cateId = cateId;
		this.cateName = cateName;
		this.cateImage = cateImage;
		this.productCount = productCount;
	}

	public Long getCateId() {
		return cateId;
	}

	public void setCateId(Long cateId) {
		this.cateId = cateId;
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
