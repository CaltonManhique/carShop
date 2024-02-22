package com.hibernate.carShop.dao;

import com.hibernate.carShop.entity.Car;

import java.util.List;

public interface CarDAOInterface {

    void save(Car car);

    Car findCarByPrimaryKey(Integer primaryKey);

    List<Car> findAllCars();

    List<Car> findCarByBrand(String brand);

}
