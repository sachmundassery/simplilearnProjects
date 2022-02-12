package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AdminLogin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/admin")
public class AdminController {
//	AdminLogin adminLogin;
	AdminLogin adminLoggedIn;
	
	private String adminEmail;
    
	@Autowired
	AdminService adminService; 
	
	@Autowired
	AdminRepository adminRepository;
	 
	@PostMapping("/login")
	public Boolean validateAdmin(@RequestBody AdminLogin adminLogin) {
		adminLoggedIn=adminLogin;
		adminEmail=adminLogin.getAdminEmail();
		adminLoggedIn.setAdminEmail(adminEmail);
		Boolean adminLoginStatus = adminService.findByAdminMail(adminLogin);
		return adminLoginStatus; 
	} 
	 
	@PutMapping("/changePassword")
	public void updatePassword(@RequestBody String newPassword) {
		AdminLogin existingAdmin = adminRepository.findById(adminLoggedIn.getAdminEmail()).orElse(null);
		existingAdmin.setAdminPassword(newPassword);
		System.out.println(newPassword+"---"+ adminLoggedIn.getAdminEmail());
		adminRepository.save(existingAdmin);
		
	} 
	
}
