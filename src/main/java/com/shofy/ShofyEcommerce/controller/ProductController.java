package com.shofy.ShofyEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.PageDto;
import com.shofy.ShofyEcommerce.dto.product.ProductDetailDto;
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

	@GetMapping("/detail/{id}")
	public ResponseEntity<ProductDetailDto> getProductDetail(@PathVariable Long id) {
		return productService.getProductDetail(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/list-product/desc")
	public List<ProductDto> getProductDesc() {
		return productService.getListProductDesc();
	}
	
	@GetMapping("/list-product/asc")
	public List<ProductDto> getProductAsc() {
		return productService.getListProductAsc();
	}
	
	@GetMapping("/pagination/{page}")
	public PageDto paginate(@PathVariable int page,
            @RequestParam(defaultValue = "6") int size) {
		return productService.getProductPage(page, size);
	}

}
