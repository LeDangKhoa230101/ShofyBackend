package com.shofy.ShofyEcommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shofy.ShofyEcommerce.dto.ColorDto;
import com.shofy.ShofyEcommerce.dto.ImageDto;
import com.shofy.ShofyEcommerce.dto.product.ProductDetailDto;
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
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}

		return productDtos;
	}

	public List<ProductDto> getListProductFeatured() {
		List<Object[]> results = productRepository.getProductFeatured();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}

		return productDtos;
	}

	public List<ProductDto> getListProductSeller() {
		List<Object[]> results = productRepository.getProductSeller();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}

		return productDtos;
	}

	// Get List Product
	public List<ProductDto> getListProduct() {
		List<Object[]> results = productRepository.getProduct();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (Object[] result : results) {
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}
		return productDtos;
	}

	// get product by id
	public Optional<ProductDetailDto> getProductDetail(Long id) {
		List<Object[]> result = productRepository.getProductById(id);

		if (result.isEmpty()) {
			return Optional.empty();
		}

		Object[] res = result.get(0);

		ProductDetailDto detailDto = new ProductDetailDto();
		detailDto.setName((String) res[0]);
		detailDto.setPriceOld((Double) res[1]);
		detailDto.setPriceNew((Double) res[2]);
		detailDto.setDescription((String) res[3]);
		detailDto.setImageDefault((String) res[4]);
		detailDto.setCateName((String) res[5]);
		detailDto.setBrandName((String) res[6]);

		String colorsJson = (String) res[7];
		String imagesJson = (String) res[8];

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			List<ColorDto> colors = objectMapper.readValue(colorsJson, new TypeReference<List<ColorDto>>() {
			});
			List<ImageDto> images = objectMapper.readValue(imagesJson, new TypeReference<List<ImageDto>>() {
			});
			detailDto.setColors(colors);
			detailDto.setImages(images);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.of(detailDto);
	}

	// get product Desc
	public List<ProductDto> getListProductDesc() {
		List<Object[]> results = productRepository.getProductByDesc();

		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Object[] result : results) {
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}
		return productDtos;
	}

	// get product Asc
	public List<ProductDto> getListProductAsc() {
		List<Object[]> results = productRepository.getProductByAsc();

		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Object[] result : results) {
			Long id = ((Number) result[0]).longValue();
			String name = (String) result[1];
			double priceOld = (double) result[2];
			double priceNew = (double) result[3];
			String imageDefault = (String) result[4];
			String cateName = (String) result[5];
			productDtos.add(new ProductDto(id, name, priceOld, priceNew, imageDefault, cateName));
		}
		return productDtos;
	}
}
