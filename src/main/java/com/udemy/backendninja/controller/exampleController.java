package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class exampleController {

    public static final String EXAMPLE_VALUE="example";

    //Primera forma de retornar una plantilla
    @GetMapping("/exampleString")
    //@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    public String exampleString(){
        return EXAMPLE_VALUE;
    }
    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        return new ModelAndView(EXAMPLE_VALUE);
    }



}
