package com.shofy.ShofyEcommerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "colors")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String color;
	
	@OneToMany(mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductColor> productColors;

	public Color() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<ProductColor> getProductColors() {
		return productColors;
	}

	public void setProductColors(List<ProductColor> productColors) {
		this.productColors = productColors;
	}
	
}
