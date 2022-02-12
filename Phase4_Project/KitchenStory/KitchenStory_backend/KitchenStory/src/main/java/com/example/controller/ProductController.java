package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import com.example.model.Products;



@CrossOrigin("*")
@RestController
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/getAllItems")
	public List<Products> getAllItems() {
		List<Products> product = (List<Products>) productRepository.findAll();
		return product;
	}
	
	@GetMapping("/getProduct/{id}")
	public Products getProduct(@PathVariable("id")int id) {
		Products product =productRepository.findById(id).orElse(null);
		return product;
	}
	
	@PostMapping(path = "/addItem")
	public @ResponseBody void addProduct(@RequestBody Products product) {
		System.out.println("inside add product ----"+product.getCategory());
		productRepository.save(product);
		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable("id")int id) {
		Products product =productRepository.findById(id).orElse(null);
		productRepository.delete(product);
		
	}
}
