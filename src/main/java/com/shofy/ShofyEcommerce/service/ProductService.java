package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.product.ProductDto;
import com.shofy.ShofyEcommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDto> getListProductNew() {
		List<Object[]> results = productRepository.getProductNew();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			 String name = (String) result[0];
			 double priceOld = (double) result[1];
			 double priceNew = (double) result[2];
			 String imageDefault = (String) result[3];
			 String cateName = (String) result[4];
			 productDtos.add(new ProductDto(name, priceOld, priceNew, imageDefault, cateName));
		}
		
		return productDtos;
	}
	
	public List<ProductDto> getListProductFeatured() {
		List<Object[]> results = productRepository.getProductFeatured();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			 String name = (String) result[0];
			 double priceOld = (double) result[1];
			 double priceNew = (double) result[2];
			 String imageDefault = (String) result[3];
			 String cateName = (String) result[4];
			 productDtos.add(new ProductDto(name, priceOld, priceNew, imageDefault, cateName));
		}
		
		return productDtos;
	}
	
	public List<ProductDto> getListProductSeller() {
		List<Object[]> results = productRepository.getProductSeller();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			 String name = (String) result[0];
			 double priceOld = (double) result[1];
			 double priceNew = (double) result[2];
			 String imageDefault = (String) result[3];
			 String cateName = (String) result[4];
			 productDtos.add(new ProductDto(name, priceOld, priceNew, imageDefault, cateName));
		}
		
		return productDtos;
	}
	
	// Get List Product
	public List<ProductDto> getListProduct() {
		List<Object[]> results = productRepository.getProduct();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for(Object[] result : results) {
			String name = (String) result[0];
			double priceOld = (double) result[1];
			double priceNew = (double) result[2];
			String imageDefault = (String) result[3];
			String cateName = (String) result[4];
			productDtos.add(new ProductDto(name, priceOld, priceNew, imageDefault, cateName));
		}
		return productDtos;
	}
}











