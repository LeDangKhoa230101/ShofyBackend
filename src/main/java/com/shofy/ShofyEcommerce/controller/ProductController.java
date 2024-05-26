package com.shofy.ShofyEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.product.ProductDto;
import com.shofy.ShofyEcommerce.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list-product-new")
	public List<ProductDto> getListProductNew() {
		return productService.getListProductNew();
	}
	
	@GetMapping("/list-product-featured")
	public List<ProductDto> getListProductFeatured() {
		return productService.getListProductFeatured();
	}
	
	@GetMapping("/list-product-seller")
	public List<ProductDto> getListProductSeller() {
		return productService.getListProductSeller();
	}
	
	@GetMapping("/list-product")
	public List<ProductDto> getListProduct() {
		return productService.getListProduct();
	}
}
