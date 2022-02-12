package com.example.service;

import com.example.model.AdminLogin;

public interface AdminService {
	
	Boolean findByAdminMail(AdminLogin adminLogin);

}
