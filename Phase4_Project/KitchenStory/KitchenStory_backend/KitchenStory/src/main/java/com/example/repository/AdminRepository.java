package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.model.AdminLogin;

@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, String>{
	

}
