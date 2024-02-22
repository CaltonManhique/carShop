package com.hibernate.carShop;

import com.hibernate.carShop.dao.CarDAOInterface;
import com.hibernate.carShop.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarShopApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CarDAOInterface carDAO) {
        return runner -> {
             createCar(carDAO);

            // Read one of the Java objects using primary key in your database.
            readCarByPrimaryKey(carDAO);

            // Read all the Java objects in your database.
            readAllCars(carDAO);

            // Read one of the Java objects using last name in your database.
            System.out.println("\nRead one of the Java objects using last name in your database.");
            readCarByBrand(carDAO);
        };
    }

    private void readCarByBrand(CarDAOInterface carDAO) {

        List<Car> cars = carDAO.findCarByBrand("Skoda");

        cars.forEach(System.out::println);
    }

    private void readAllCars(CarDAOInterface carDAO) {

        List<Car> cars = carDAO.findAllCars();

        cars.forEach(System.out::println);
    }

    private void readCarByPrimaryKey(CarDAOInterface carDAO) {

        Car newCar = new Car("VW", "Golf GTD", "1900 cc", "Diesel", 1992);

        carDAO.save(newCar);

        Car car = carDAO.findCarByPrimaryKey(newCar.getId());

        System.out.println(car);
    }

    private void createCar(CarDAOInterface carDAO) {

        Car newCar = new Car("Skoda", "Octavia", "1599 cc", "Diesel", 2010);

        carDAO.save(newCar);

        System.out.println("Car created with id: " + newCar.getId());
    }
}
