package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shofy.ShofyEcommerce.dto.CategoryDto;
import com.shofy.ShofyEcommerce.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryDto> getCategoryAndProductCount() {
		List<Object[]> results = categoryRepository.findCategoryProductCounts();
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for(Object[] result : results) {
			String cateName = (String) result[0];
			String cateImage = (String) result[1];
			Long productCount = ((Number) result[2]).longValue();
			categoryDtos.add(new CategoryDto(cateName, cateImage, productCount));
		}
		return categoryDtos;
	}
	
}
