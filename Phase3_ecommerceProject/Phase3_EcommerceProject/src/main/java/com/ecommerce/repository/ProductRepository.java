package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ecommerce.models.Products;
import org.springframework.data.domain.Sort;

public interface ProductRepository extends CrudRepository<Products, Integer> {
	Iterable<Products> findAll(Sort sort);

	public List<Products> findAllProductsByCategory(String category);

	public List<Products> findAllProductsBySeason(String season);

	public List<Products> findAllProductsByColor(String color);

	public List<Products> findAllProductsByBrand(String brand);
//	public List<Products> findAllProductsByPrice(String priceOrder);
}
