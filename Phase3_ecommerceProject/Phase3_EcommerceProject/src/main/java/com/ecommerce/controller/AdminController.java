package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.Admin;
import com.ecommerce.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/admins")
	public List<Admin> findAllAdmins()
	{
		return service.getAdmins();
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin)
	{
		return service.updateAdmin(admin);
	}
}
