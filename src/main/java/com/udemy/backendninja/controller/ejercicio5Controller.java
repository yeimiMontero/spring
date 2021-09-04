package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/ejercicio")
public class ejercicio5Controller {

    public static final String PAGINA="nuevo";
    @GetMapping("/mensaje")
    public String mensaje(){
        return PAGINA;
    }
    @GetMapping("/")
    public RedirectView redirigir(){
        return  new RedirectView("/ejercicio/mensaje");
    }

}
