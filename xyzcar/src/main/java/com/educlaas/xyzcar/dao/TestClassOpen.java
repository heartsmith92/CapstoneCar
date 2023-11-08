package com.educlaas.xyzcar.dao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TestClassOpen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long testOpenId;
	
}
