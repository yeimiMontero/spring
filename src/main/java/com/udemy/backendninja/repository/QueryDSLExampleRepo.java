package com.udemy.backendninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    private QCourse qCourse =QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public void find(boolean exist){
        JPAQuery<Course> query= new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if(exist){
           // Predicate predicate2= qCourse.id.eq(23);
            BooleanExpression predicate2= qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        }else {
            BooleanExpression predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.or(predicate3);
        }
        //Te trae solo un registro
        //Course course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
        Course course = query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

        //Te trae una lista
        //List<Course> courses= query.select(qCourse).from(qCourse).where(qCourse.hours.between(20,50)).fetch();
    }
}
