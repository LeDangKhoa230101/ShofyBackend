package com.shofy.ShofyEcommerce.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "token")
	private String token;

	@Column(name = "create_at")
	private Date createAt;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	public Token() {
		super();
	}

	public Token(User user) {
		this.user = user;
		this.createAt = new Date();
		this.token = UUID.randomUUID().toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
