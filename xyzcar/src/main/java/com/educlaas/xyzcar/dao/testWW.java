package com.educlaas.xyzcar.dao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class testWW {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long testId;
}
