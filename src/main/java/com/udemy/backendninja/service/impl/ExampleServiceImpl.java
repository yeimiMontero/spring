package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
//Con esto se generará un bean que va iniciar con el arranque del servidor
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG= LogFactory.getLog(ExampleServiceImpl.class);
    @Override
    public List<Person> getListPeople() {
        List<Person> people= new ArrayList<>();
        people.add(new Person("Yeimi",23));
        people.add(new Person("Alan",24));
        people.add(new Person("Irvin",17));
        people.add(new Person("Kyara",4));
        people.add(new Person("Hachi",4));
        LOG.info("HELLO FROM SERVICE");
        return people;
    }
}
