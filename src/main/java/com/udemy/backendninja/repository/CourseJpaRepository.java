package com.udemy.backendninja.repository;

import com.udemy.backendninja.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course , Integer> {

    //Se puede hacer métodos abstractos

    public abstract Course findByPrice(int price);

    public abstract Course findByPriceAndName(int price, String name);

    public abstract List<Course> findByNameOrderByHours(String name);

    public abstract Course findByNameOrPrice(String name , int price);
}
