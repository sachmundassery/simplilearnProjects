package com.ecommerce.service;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.ProductOrder;
import com.ecommerce.models.Products;
import com.ecommerce.models.User;

@Repository
public class ProductOrderMySQLDAO {
	private final JdbcTemplate jdbcTemplate;
	public ProductOrderMySQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	 
	public List<ProductOrder> getAllPurchaseOrders() {
		return jdbcTemplate.query("SELECT * FROM product_order", (rs, rowNum) -> {
			
			ProductOrder order = new ProductOrder();
			int productId = rs.getInt(2);
			int userId = rs.getInt(3);
			
			Products product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = ?", (rs1, rowNum1) -> {
				Products productInner = new Products();
				System.out.println(rs1.getInt(1)+"----------------Product ID-------------");
				productInner.setProductId(rs1.getInt(1));
				productInner.setBrand(rs1.getString(2));
				productInner.setCategory(rs1.getString(3));
				productInner.setColor(rs1.getString(4));
				productInner.setCreatedDate(rs1.getString(5));
				productInner.setDiscount(rs1.getInt(6));
				productInner.setPrice(rs1.getInt(7));
				productInner.setProductName(rs1.getString(8));
				
				productInner.setQuantity(rs1.getInt(9));
				productInner.setSeason(rs1.getString(10));
				return productInner;
			}, productId);
			User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE user_id = ?", (rs2, rowNum2) -> {
				User u = new User();
				u.setUserId(rs2.getInt(1));
				u.setEmail(rs2.getString(2));
				u.setPassword(rs2.getString(3));
				u.setPhone_number(rs2.getString(4));
				u.setUsername(rs2.getString(5));
				return u;
			}, userId);
			
			order.setProduct(product);
			order.setUser(user);
			return order;
					
		});
		
	}
	
	public List<ProductOrder> getFilteredOrders(String date, String category) {
        List<ProductOrder> orders = getAllPurchaseOrders();

        if (date != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCreatedDate().toString().equals(date))
                    .toList();
        }
        if (category != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getCategory().equals(category))
                    .toList();
        }
        return orders;
    }
}
