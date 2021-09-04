package com.udemy.backendninja.controller;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/complex")
public class exampleWithComplexData {

    public static final String EXAMPLE_VALUE="example";

    //Primera forma de retornar una plantilla
    @GetMapping("/exampleString")
    public String exampleeString(Model model){

        model.addAttribute("person",new Person("Yeimi",23));
        return EXAMPLE_VALUE;

    }
    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav= new ModelAndView(EXAMPLE_VALUE);
        mav.addObject("person",new Person("Alan",24));
        return mav;
    }
    /*private List<Person> getPeople(){

        List<Person> people= new ArrayList<>();
        people.add(new Person("Yeimi",23));
        people.add(new Person("Alan",24));
        people.add(new Person("Irvin",17));
        people.add(new Person("Kyara",4));
        people.add(new Person("Hachi",4));
        return  people;
    }*/
}
