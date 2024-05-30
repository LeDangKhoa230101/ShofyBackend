package com.shofy.ShofyEcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "SELECT c.id AS cateId, c.name AS cateName, c.image AS cateImage, COUNT(p.id) AS productCount " 
			+ "FROM categorys c "
			+ "LEFT JOIN products p ON c.id = p.cateId " 
			+ "GROUP BY c.id, c.name, c.image", nativeQuery = true)
	List<Object[]> findCategoryProductCounts();

	@Query(value = "SELECT p.id, p.name, p.priceOld, p.priceNew, p.imageDefault, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cateId = c.id AND c.name = ?", nativeQuery = true)
	List<Object[]> getProductByCategory(@Param("name") String name);
	
}
