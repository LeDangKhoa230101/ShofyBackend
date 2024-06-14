package com.shofy.ShofyEcommerce.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "price_old")
	private double priceOld;
	
	@Column(name = "price_new")
	private double priceNew;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image_default")
	private String imageDefault;

	@ManyToOne
	@JoinColumn(name = "cate_id")
	@JsonBackReference
	private Category category;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@Column(name = "product_new")
	private boolean productNew;
	
	@Column(name = "product_featured")
	private boolean productFeatured;
	
	@Column(name = "product_seller")
	private boolean productSeller;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Column(name = "update_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductColor> productColors;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, double priceOld, double priceNew, String description, String imageDefault,
			Category category, Brand brand, boolean productNew, boolean productFeatured, boolean productSeller,
			Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.name = name;
		this.priceOld = priceOld;
		this.priceNew = priceNew;
		this.description = description;
		this.imageDefault = imageDefault;
		this.category = category;
		this.brand = brand;
		this.productNew = productNew;
		this.productFeatured = productFeatured;
		this.productSeller = productSeller;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceOld() {
		return priceOld;
	}

	public void setPriceOld(double priceOld) {
		this.priceOld = priceOld;
	}

	public double getPriceNew() {
		return priceNew;
	}

	public void setPriceNew(double priceNew) {
		this.priceNew = priceNew;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageDefault() {
		return imageDefault;
	}

	public void setImageDefault(String imageDefault) {
		this.imageDefault = imageDefault;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public boolean isProductNew() {
		return productNew;
	}

	public void setProductNew(boolean productNew) {
		this.productNew = productNew;
	}

	public boolean isProductFeatured() {
		return productFeatured;
	}

	public void setProductFeatured(boolean productFeatured) {
		this.productFeatured = productFeatured;
	}

	public boolean isProductSeller() {
		return productSeller;
	}

	public void setProductSeller(boolean productSeller) {
		this.productSeller = productSeller;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<ProductColor> getProductColors() {
		return productColors;
	}

	public void setProductColors(List<ProductColor> productColors) {
		this.productColors = productColors;
	}
	
}
