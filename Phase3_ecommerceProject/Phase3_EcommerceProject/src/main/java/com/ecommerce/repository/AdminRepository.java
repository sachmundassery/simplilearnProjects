package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.models.Admin;



public interface AdminRepository extends CrudRepository<Admin, String> {

	
}
