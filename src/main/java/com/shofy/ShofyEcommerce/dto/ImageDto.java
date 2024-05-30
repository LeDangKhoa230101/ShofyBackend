package com.shofy.ShofyEcommerce.dto;

public class ImageDto {
	private Long imgId;
	private String imageUrl;

	public ImageDto() {
		super();
	}

	public ImageDto(Long imgId, String imageUrl) {
		super();
		this.imgId = imgId;
		this.imageUrl = imageUrl;
	}

	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
