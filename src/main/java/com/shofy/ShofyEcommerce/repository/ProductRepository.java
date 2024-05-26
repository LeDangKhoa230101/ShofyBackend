package com.shofy.ShofyEcommerce.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = "SELECT p.name, p.priceOld, p.priceNew, p.imageDefault, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.productNew = true AND p.cateId = c.id", nativeQuery = true)
	List<Object[]> getProductNew();
	
	@Query(value = "SELECT p.name, p.priceOld, p.priceNew, p.imageDefault, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.productFeatured = true AND p.cateId = c.id", nativeQuery = true)
	List<Object[]> getProductFeatured();
	
	@Query(value = "SELECT p.name, p.priceOld, p.priceNew, p.imageDefault, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.productSeller = true AND p.cateId = c.id", nativeQuery = true)
	List<Object[]> getProductSeller();
	
	@Query(value = "SELECT p.name, p.priceOld, p.priceNew, p.imageDefault, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cateId = c.id", nativeQuery = true)
	List<Object[]> getProduct();
	
}
