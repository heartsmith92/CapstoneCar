package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.educlaas.xyzcar.dao.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	@Query(value = "SELECT c FROM Car c where make LIKE '%'|| :keyword || '%' "
			+ "OR model LIKE '%'|| :keyword || '%'")
	public List<Car> searchCar(@Param("keyword") String keyword);
	
	@Query(value = "SELECT c FROM Car c where priceRange BETWEEN :lower AND :upper")
	public List<Car> searchPrice(@Param("lower") Double lower, @Param("upper") Double upper);
}
