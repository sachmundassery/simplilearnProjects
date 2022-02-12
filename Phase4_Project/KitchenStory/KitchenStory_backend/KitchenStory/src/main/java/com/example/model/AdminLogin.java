package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_adminLogin")
@Setter
@Getter

public class AdminLogin {

	@Id
	private String adminEmail;
	private String adminPassword;
}
