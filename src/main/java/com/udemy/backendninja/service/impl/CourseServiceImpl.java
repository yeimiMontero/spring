package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired //Le indicamos a Spring que vamos a inyectar algo
    @Qualifier("courseJpaRepository")

    private CourseJpaRepository courseJpaRepository;

    @Override
    public List<Course> listAllCourses() {
        LOG.info("Call: "+"listAllCourses()");
        //Devuelve el listado de cursos.(findAll)
        return courseJpaRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        LOG.info("Call: "+"addCourse");
        return courseJpaRepository.save(course);
        //Save guarda en la base de datos y si lo hace correctamente te regresa el objeto
        //que acabamos de guardar
    }

    @Override
    public int removeCourse(int id) {
       // courseJpaRepository.delete(id);
        return 0;

    }

    @Override
    public Course updateCourse(Course course) {
        return null;
        //Va a intentar meter el curso que nosotros le enviemos, si este curso tiene un id
        //Revisará si existe, si existe hace un update
    }
}
