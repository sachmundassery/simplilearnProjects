package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Products;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping(path = "/ecommerce")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@PostMapping(path = "/addProduct")
	public @ResponseBody String addProduct(@RequestBody Products product) {
		productRepository.save(product);
		return "Data saved successfully";
	}

	@GetMapping("getProductById/{productId}")
	public Optional<Products> getbookId(@PathVariable int productId) {
		return productRepository.findById(productId);
	}

	@GetMapping("getAllProducts")
	public List<Products> getAllProducts() {
		List<Products> product = (List<Products>) productRepository.findAll();
		return product;
	}

	@GetMapping("getProductByCategory/{category}")
	public List<Products> getProductByCategory(@PathVariable String category) {
		List<Products> product = (List<Products>) productService.findAllProductsByCategory(category);
		return (List<Products>) product;
	}

	@GetMapping("getProductBySeason/{season}")
	public List<Products> getProductBySeason(@PathVariable String season) {
		List<Products> product = (List<Products>) productService.findAllProductsBySeason(season);
		return (List<Products>) product;
	}

	@GetMapping("getProductByColor/{color}")
	public List<Products> getProductByColor(@PathVariable String color) {
		List<Products> product = (List<Products>) productService.findAllProductsByColor(color);
		return (List<Products>) product;
	}

	@GetMapping("getProductByBrand/{brand}")
	public List<Products> getProductByBrand(@PathVariable String brand) {
		List<Products> product = (List<Products>) productService.findAllProductsByBrand(brand);
		return (List<Products>) product;
	}

	@GetMapping("getProductByPrice/{priceOrder}")
	public List<Products> getProductByPrice(@PathVariable String priceOrder) {
		List<Products> product;
		if (priceOrder.equals("asc")) {
			product = (List<Products>) productRepository.findAll(Sort.by("price"));
		} else {
			product = (List<Products>) productRepository.findAll(Sort.by("price").descending());
		}

		return  product;
	}
	@GetMapping("getProductByDate/{dateOrder}")
	public List<Products> getProductByDate(@PathVariable String dateOrder) {
		List<Products> product;
		if (dateOrder.equals("asc")) {
			product = (List<Products>) productRepository.findAll(Sort.by("createdDate"));
		} else {
			product = (List<Products>) productRepository.findAll(Sort.by("createdDate").descending());
		}

		return product;
	}


	@PutMapping("updateProductById/{productId}")
	public Products updateProductById(@PathVariable int productId, @RequestBody Products newProduct) {
		return productService.updateProductById(productId, newProduct);
	}

	@DeleteMapping("deleteProductById/{productId}")
	public String deleteAProductById(@PathVariable int productId) {
		productRepository.deleteById(productId);
		return "Deleted the product with ID : " + productId;
	}

	@DeleteMapping("deleteAllProducts")
	public String deleteAppProducts() {
		productRepository.deleteAll();
		return "Deleted all the products";
	}

	// Search?
}
