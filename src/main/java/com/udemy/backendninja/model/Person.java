package com.udemy.backendninja.model;

import com.sun.istack.internal.NotNull;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.boot.convert.DataSizeUnit;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(){

    }
    //Lo primero que Spring necesita para validar un formulario es que el
    //modelo que le vamos a pasar disponga de ciertas anotaciones
    //en sus atributos.

    @NotNull
    @Size(min=2,max=6)
    private String name;
    @NotNull
    @Min(18)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
