package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class example4Controller {

    private static final String VIEW="404.html";


    @GetMapping("/mostrarPagina")
    public String getView() {
        return VIEW;
    }


}
