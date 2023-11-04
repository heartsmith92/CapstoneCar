package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dao.Car;

@Service
public interface CarService {
	public void postCar(Car car);
	public List<Car> getCar();
	public Optional<Car> viewCar(Long carId);
	public void deleteCar(Long carId);
	public List<Car> searchCar(String keyword);
	public List<Car> searchPrice(Double lower, Double upper);
}
