package com.shofy.ShofyEcommerce.dto;

import java.util.List;

import com.shofy.ShofyEcommerce.dto.product.ProductDto;

public class PageDto {
	private List<ProductDto> productDtos;
	private Long totalProducts;

	public PageDto() {
		super();
	}

	public PageDto(List<ProductDto> productDtos, Long totalProducts) {
		super();
		this.productDtos = productDtos;
		this.totalProducts = totalProducts;
	}

	public List<ProductDto> getProductDtos() {
		return productDtos;
	}

	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}

	public Long getTotalProducts() {
		return totalProducts;
	}

	public void setTotalProducts(Long totalProducts) {
		this.totalProducts = totalProducts;
	}

}
