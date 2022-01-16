package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.ecommerce.models.ProductOrder;
import com.ecommerce.models.Products;

//public interface ProductOrderRepository extends CrudRepository<ProductOrder, Integer> {
//}
public interface ProductOrderRepository extends CrudRepository<Products, Integer> {
}
