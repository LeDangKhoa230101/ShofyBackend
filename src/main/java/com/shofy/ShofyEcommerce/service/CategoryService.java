package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.CategoryDto;
import com.shofy.ShofyEcommerce.dto.product.ProductDto;
import com.shofy.ShofyEcommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryDto> getCategoryAndProductCount() {
		List<Object[]> results = categoryRepository.findCategoryProductCounts();
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for(Object[] result : results) {
			Long cateId = ((Number) result[0]).longValue();
			String cateName = (String) result[1];
			String cateImage = (String) result[2];
			Long productCount = ((Number) result[3]).longValue();
			categoryDtos.add(new CategoryDto(cateId, cateName, cateImage, productCount));
		}
		return categoryDtos;
	}

	public List<ProductDto> getListProductByCate(String name) {
		List<Object[]> results = categoryRepository.getProductByCategory(name);
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for(Object[] res : results) {
			Long id = ((Number) res[0]).longValue();
			String productName = (String) res[1];
			double priceOld = (double) res[2];
			double priceNew = (double) res[3];
			String imageUrl = (String) res[4];
			String cateName = (String) res[5];
			productDtos.add(new ProductDto(id, productName, priceOld, priceNew, imageUrl, cateName));
		}
		return productDtos;
		
	}
	
}
