package com.udemy.backendninja.controller;


import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/courses")
public class CourseController {

    private static final String COURSES_VIEW = "courses";
    private static final Log LOG= LogFactory.getLog(CourseController.class);

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ModelAndView listAllCourses(){
        LOG.info("Call:" +"listAllCourses()");
        ModelAndView mav = new ModelAndView(COURSES_VIEW);
        mav.addObject("course", new Course());
        mav.addObject("courses", courseService.listAllCourses());
        return mav;
    }
    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute("course") CourseModel coursemodel){
        LOG.info("Call:" +"addCourse() "+"-- Param: "+coursemodel.toString());
        courseService.addCourse(coursemodel);
        return "redirect:/courses/listcourses";

    }
    @PutMapping("/updatecourse")
    public String updateCourse(@ModelAttribute("course") CourseModel coursemodel){
        LOG.info("Call:" +"addCourse() "+"-- Param: "+coursemodel.toString());
        courseService.updateCourse(coursemodel);
        return "redirect:/courses/listcourses";
    }

}
