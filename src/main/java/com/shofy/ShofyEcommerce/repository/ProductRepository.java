package com.shofy.ShofyEcommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shofy.ShofyEcommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.product_new = true AND p.cate_id = c.id", nativeQuery = true)
	List<Object[]> getProductNew();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.product_featured = true AND p.cate_id = c.id", nativeQuery = true)
	List<Object[]> getProductFeatured();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.product_seller = true AND p.cate_id = c.id", nativeQuery = true)
	List<Object[]> getProductSeller();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cate_id = c.id", nativeQuery = true)
	List<Object[]> getProduct();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.description, p.image_default, t.name AS cateName, b.name AS brandName, "
	        + "    (SELECT JSON_ARRAYAGG(JSON_OBJECT("
	        + "				'colorId', c.id, "
	        + "				'color', c.color "
	        + "			)"
	        + "        )"
	        + "	FROM colors c "
	        + "    JOIN products_colors pc ON c.id = pc.color_id "
	        + "    WHERE pc.product_id = p.id "
	        + "    ) AS colors, "
	        + "    (SELECT JSON_ARRAYAGG(JSON_OBJECT("
	        + "				'imgId', i.id, "
	        + "				'imageUrl', i.image_url "
	        + "			)"
	        + "		)"
	        + "	FROM images i "
	        + "    WHERE i.product_id = p.id "
	        + "    ) AS images "
	        + "FROM products p "
	        + "JOIN categorys t ON p.cate_id = t.id "
	        + "JOIN brands b ON p.brand_id = b.id "
	        + "WHERE p.id = :id "
	        + "GROUP BY p.id",
	        nativeQuery = true)
	List<Object[]> getProductById(@Param("id") Long id);
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cate_id = c.id "
			+ "ORDER BY p.price_new DESC", nativeQuery = true)
	List<Object[]> getProductByDesc();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cate_id = c.id "
			+ "ORDER BY p.price_new ASC", nativeQuery = true)
	List<Object[]> getProductByAsc();
	
	@Query(value = "SELECT p.id, p.name, p.price_old, p.price_new, p.image_default, c.name AS cateName "
			+ "FROM products p, categorys c "
			+ "WHERE p.cate_id = c.id "
			+ "LIMIT :size OFFSET :offset", nativeQuery = true)
	List<Object[]> pagination(@Param("offset") Integer offset, @Param("size") Integer size);
	
	
	@Query(value = "SELECT COUNT(*) FROM products", nativeQuery = true)
    long countAllProducts();
	
}
















