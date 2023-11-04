package com.educlaas.xyzcar.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dao.Car;
import com.educlaas.xyzcar.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarRepository carRepo;

	@Override
	public void postCar(Car car){
		car.setCreatedDateTime(LocalDateTime.now());
		carRepo.save(car);
	}

	@Override
	public List<Car> getCar() {
		return carRepo.findAll();
	}

	@Override
	public Optional<Car> viewCar(Long carId) {
		return carRepo.findById(carId);
	}

	@Override
	public void deleteCar(Long carId) {
		carRepo.deleteById(carId);
	}

	@Override
	public List<Car> searchCar(String keyword) {
		return carRepo.searchCar(keyword);
	}

	@Override
	public List<Car> searchPrice(Double lower, Double upper) {
		return carRepo.searchPrice(lower, upper);
	}
	
	

}
