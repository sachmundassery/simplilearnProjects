package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.AdminLogin;
import com.example.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Boolean findByAdminMail(AdminLogin adminLogin) {

		if (adminRepository.findById(adminLogin.getAdminEmail()).isPresent()) {
			AdminLogin admin = adminRepository.findById(adminLogin.getAdminEmail()).get();
			
			System.out.println(admin.getAdminPassword()+"--------"+adminLogin.getAdminPassword());
			
			String dbPassword = admin.getAdminPassword().toString();
			String userInputPassword =adminLogin.getAdminPassword().toString();
			
			if (dbPassword.equals(userInputPassword)) {
				
				return true;
			}
		}
		
		return false;
	}

}
