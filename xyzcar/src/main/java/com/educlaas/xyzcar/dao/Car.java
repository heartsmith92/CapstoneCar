package com.educlaas.xyzcar.dao;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId;
	
	private String make;
	private String model;
	private String registration;
	private Double priceRange;
	private String carProfileImg;
	private String userEmail;
	private String status;
	private LocalDateTime createdDateTime;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCarProfileImg() {
		return carProfileImg;
	}
	public void setCarProfileImg(String carProfileImg) {
		this.carProfileImg = carProfileImg;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public Double getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(Double priceRange) {
		this.priceRange = priceRange;
	}
	public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
	
}
