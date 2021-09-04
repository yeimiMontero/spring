package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/examplee")
public class ExampleeController {

    public static final String EXAMPLE_VALUE="example";
    //Primera forma de retornar una plantilla
    @GetMapping("/exampleeString")
    //@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
    public String exampleeString(Model model){
        model.addAttribute("name","Yeimi");
        return EXAMPLE_VALUE;

    }
    //Segunda forma
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav= new ModelAndView(EXAMPLE_VALUE);
        mav.addObject("name","Yeimi");
        return mav;
    }

}
