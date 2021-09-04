package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Para que Spring sepa que esta clase se encarga de la captura de errores le ponemos
//Spring sabe que cuando se produce un error vendrá a esta clase
@ControllerAdvice
public class ErrorsController {

    public static final String ISE_VIEW="error/500";

    //Recibe un parametro con el tipo de EXCEPCIÓN a capturar
    // en este caso se capturaratodo tipo de excepciones

    @ExceptionHandler(Exception.class)
    public String showIntervalServerError(){
        return ISE_VIEW;
    }

}
