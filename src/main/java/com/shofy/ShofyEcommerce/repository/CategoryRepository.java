package com.shofy.ShofyEcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value = "SELECT c.name AS cateName, c.image AS cateImage, COUNT(p.id) AS productCount " 
			+ "FROM categorys c "
			+ "LEFT JOIN products p ON c.id = p.cateId " 
			+ "GROUP BY c.name, c.image", nativeQuery = true)
	List<Object[]> findCategoryProductCounts();

}
