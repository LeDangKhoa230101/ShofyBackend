package com.shofy.ShofyEcommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products_colors")
public class ProductColor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	public ProductColor() {
		super();
	}

	public ProductColor(Long id, Product product, Color color) {
		super();
		this.id = id;
		this.product = product;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
