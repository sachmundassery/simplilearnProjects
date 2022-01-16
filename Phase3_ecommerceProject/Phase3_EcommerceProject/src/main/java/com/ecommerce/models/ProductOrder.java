package com.ecommerce.models;

public class ProductOrder {

	private User user;
	private Products product;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}

}
