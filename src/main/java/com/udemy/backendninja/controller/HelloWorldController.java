package com.udemy.backendninja.controller;

import com.udemy.backendninja.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "helloworld";
    }

    @GetMapping(value = "/goodbye", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> goodbye(){
        Person person = new Person();
        person.setName("Puchi");
        person.setAge(10L);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
