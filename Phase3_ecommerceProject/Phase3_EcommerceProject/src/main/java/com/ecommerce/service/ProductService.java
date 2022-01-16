package com.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.models.Products;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService (ProductRepository productRepository ) {
		this.productRepository=productRepository;
	}
	
	public Products updateProductById(int productId, Products newProduct) {
		Products oldProduct = productRepository.findById(productId).get();
		oldProduct.setProductName(newProduct.getProductName());
		oldProduct.setSeason(newProduct.getSeason());
		oldProduct.setBrand(newProduct.getBrand());
		oldProduct.setCategory(newProduct.getCategory());
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setColor(newProduct.getColor());
		oldProduct.setCreatedDate(newProduct.getCreatedDate());
		oldProduct.setDiscount(newProduct.getDiscount());
		oldProduct.setQuantity(newProduct.getQuantity());
		productRepository.save(oldProduct);
		return newProduct;
	}
	
	public List<Products> findAllProductsByCategory(String category) {
		return productRepository.findAllProductsByCategory(category);
	}
	
	public List<Products> findAllProductsBySeason(String season) {
		return productRepository.findAllProductsBySeason(season);
	}
	public List<Products> findAllProductsByColor(String color) {
		return productRepository.findAllProductsByColor(color);
	}
	public List<Products> findAllProductsByBrand(String brand) {
		return productRepository.findAllProductsByBrand(brand);
	}
	

	
}
