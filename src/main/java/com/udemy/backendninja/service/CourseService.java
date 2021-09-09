package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

import java.util.List;

public interface CourseService {

    public abstract List<CourseModel> listAllCourses();
    public abstract Course addCourse(CourseModel courseModel);
    public abstract int removeCourse(Integer id);
    public abstract int findCourse(Integer id);
    public abstract Course updateCourse(CourseModel courseModel);
}
