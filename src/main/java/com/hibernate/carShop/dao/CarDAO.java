package com.hibernate.carShop.dao;

import com.hibernate.carShop.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAO implements CarDAOInterface {

    private EntityManager entityManager;

    @Autowired
    public CarDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Car car) {
        entityManager.persist(car);
    }

    @Override
    public Car findCarByPrimaryKey(Integer primaryKey) {
        return entityManager.find(Car.class, primaryKey);
    }

    @Override
    public List<Car> findAllCars() {

        TypedQuery<Car> query = entityManager.createQuery("FROM Car order by year desc", Car.class);
        return query.getResultList();
    }

    @Override
    public List<Car> findCarByBrand(String brand) {

        TypedQuery<Car> query = entityManager.createQuery("FROM Car WHERE brand=:theBrand", Car.class);
        query.setParameter("theBrand", brand);
        return query.getResultList();
    }
}
