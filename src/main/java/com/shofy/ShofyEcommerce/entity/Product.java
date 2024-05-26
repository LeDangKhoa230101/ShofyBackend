package com.shofy.ShofyEcommerce.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "priceOld", nullable = false)
	private double priceOld;

	@Column(name = "priceNew", nullable = false)
	private double priceNew;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "imageDefault", nullable = false)
	private String imageDefault;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cateId")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brandId")
	private Brand brand;

	@Column(name = "productNew", nullable = false)
	private boolean productNew;

	@Column(name = "productFeatured", nullable = false)
	private boolean productFeatured;

	@Column(name = "productSeller", nullable = false)
	private boolean productSeller;

	@Column(name = "createAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@Column(name = "updateAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateAt;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Image> images;

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
	
}