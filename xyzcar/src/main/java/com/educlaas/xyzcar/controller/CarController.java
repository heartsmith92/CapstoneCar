package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dao.Car;
import com.educlaas.xyzcar.service.CarService;

@RestController
@RequestMapping(value = "/xyz")
@CrossOrigin(origins = "http://localhost:3000/")
public class CarController {
	
	@Autowired
	private CarService carService;

	//1. Post Car API
	@PostMapping(value = "/cars")
	public void postCar(@RequestBody Car car) {
		carService.postCar(car);
	}
	
	//2. View Car API
	@GetMapping(value = "/cars")
	public List<Car> getCar(){
		return carService.getCar();
	}
	
	//3. View Car By CarId API
	@GetMapping(value = "/car/{carId}")
	public Optional<Car> viewCar(@PathVariable Long carId){
		return carService.viewCar(carId);
	}
	
	//4. Delete Existing Car by CarId API
	@DeleteMapping(value = "/cars/{carId}")
	public void deleteCar(@PathVariable Long carId) {
		carService.deleteCar(carId);
	}
	
	//5. Update Existing Car by CarId API
	@PutMapping(value = "/cars/{carId}")
	public Car updateCar(@PathVariable Long carId, @RequestBody Car car) {
		
		Optional<Car> existingCar = viewCar(carId);
		
		Car updateCar = existingCar.get();
		
		updateCar.setMake(car.getMake());
		updateCar.setModel(car.getModel());
		updateCar.setPriceRange(car.getPriceRange());
		updateCar.setRegistration(car.getRegistration());
			
		postCar(updateCar);
		
		return updateCar;
	}
	
	@PutMapping(value = "/car/status/{carId}")
	public Car updateCarStatus(@PathVariable Long carId, @RequestBody Car car) {
		
		Optional<Car> existingCar = viewCar(carId);
		
		Car updateCar = existingCar.get();
		
		updateCar.setStatus(car.getStatus());
			
		postCar(updateCar);
		
		return updateCar;
	}
	
	//6. Search Car by Keywords
	@GetMapping(value = "/cars/{keyword}")
	public List<Car> searchCar(@PathVariable String keyword){
		return carService.searchCar(keyword);
		
	}
	
	//7. Search Car by Price Range
	@GetMapping(value = "/cars/{lower}/{upper}")
	public List<Car> searchPrice(@PathVariable Double lower, @PathVariable Double upper){
		return carService.searchPrice(lower, upper);
	}
	
}
