package com.shofy.ShofyEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shofy.ShofyEcommerce.dto.CategoryDto;
import com.shofy.ShofyEcommerce.service.CategoryService;

@RestController
@RequestMapping("categorys")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list-category")
	public List<CategoryDto> getListCategory() {
		return categoryService.getCategoryAndProductCount();
	}
}
