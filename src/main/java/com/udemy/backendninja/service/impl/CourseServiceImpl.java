package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired //Le indicamos a Spring que vamos a inyectar algo
    @Qualifier("courseJpaRepository")
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseconverter;

    @Override
    public List<CourseModel> listAllCourses() {
        LOG.info("Call: " + "listAllCourses()");
        List<Course> courses = courseJpaRepository.findAll();
        //Devuelve el listado de cursos.(findAll)
        List<CourseModel> courseModels = new ArrayList<>();
        for (Course course : courses){
            courseModels.add(courseconverter.entity2model(course));
        }
        return courseModels;
    }

    @Override
    public Course addCourse(CourseModel courseModel) {
        LOG.info("Call: " + "addCourse");
        return courseJpaRepository.save(courseconverter.model2entity(courseModel));
        //Save guarda en la base de datos y si lo hace correctamente te regresa el objeto
        //que acabamos de guardar
    }

    @Override
    public int removeCourse(Integer id) {
         courseJpaRepository.deleteById(id);
        return 0;

    }

    @Override
    public int findCourse(Integer id) {
        LOG.info("Call: "+ "findCourse");
        courseJpaRepository.findById(id);
        return id;
    }

    @Override
    public Course updateCourse(CourseModel courseModel) {
        LOG.info("Call: "+ "updateCourse");
        return courseJpaRepository.save(courseconverter.model2entity(courseModel));
        //Va a intentar meter el curso que nosotros le enviemos, si este curso tiene un id
        //Revisará si existe, si existe hace un update
    }
}
