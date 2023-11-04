package com.educlaas.xyzcar.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long RoleId;
	
	private String Role;


}
