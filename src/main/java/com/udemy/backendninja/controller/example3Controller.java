package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/example3")
public class example3Controller {

    private static final Log LOOGER= LogFactory.getLog(example3Controller.class);

    public static final String FROM_VIEW = "form";
    public static final String RESULT_VIEW = "result";

    //#1
    /*@GetMapping("/")
    public String redirect(){
        return "redirect:/example3/showform";

    }*/

    //#2 forma de redireccionamiento
    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/example3/showform");
    }

    @GetMapping("/showform")
    public String showForm(Model model){
        //int i=6/0;
        /*LOOGER.info("INFO TRACE");
        LOOGER.warn("WARNING TRACE");
        LOOGER.error("ERROR TRACE");
        LOOGER.debug("DEBUG TRACE");*/
        model.addAttribute("person", new Person());
        return FROM_VIEW;
    }

    @PostMapping("/addperson")
                                  //El objeto va a permitir una validación de Spring así que se le agrega
    public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){//Lo usa Spring para verificar los campos
       // LOOGER.info("METHOD: 'addPerson' -- PARAMS: '"+ person + "'");
        ModelAndView mav= new ModelAndView();
        if(bindingResult.hasErrors()){
            mav.setViewName(FROM_VIEW);
        }else{
            mav.setViewName(RESULT_VIEW);
            mav.addObject("person" , person);
        }

        //Facilita con front-end mostrando que template se usa (html) y los datos que enviamos
        //LOOGER.info("TEMPLATE: '" +RESULT_VIEW + "' -- DATA: '"+ person + "'" );
        return mav;
    }
}
