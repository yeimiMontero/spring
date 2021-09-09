package com.udemy.backendninja.entity;

import javax.persistence.*;

@Entity
//No es necesario ponerlo si se llama igual que en la tabla
@Table(name = "course")
public class Course {
    //Al ser un id es necesario poner la notacion @Id y con el @GeneratedValue
    //Se genera el siguiente al momento de la inserción como autoincremento
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Integer price;

    @Column(name="hours")
    private Integer hours;

    //Siempre hay que dejar el contructor por defecto por que es el que usa hibernate para trabajar
    public Course(){}

    public Course(Integer id, String name, String description, Integer price, Integer hours) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", hours=" + hours +
                '}';
    }
}
