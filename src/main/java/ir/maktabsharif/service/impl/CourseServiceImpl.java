package ir.maktabsharif.service.impl;

import ir.maktabsharif.model.model.Course;
import ir.maktabsharif.service.CourseService;
import ir.maktabsharif.util.ApplicationContext;
import lombok.Builder;

import java.util.Date;

public class CourseServiceImpl implements CourseService {

    @Override
    public void addCourse(String title, String unit) {
        Course course = Course.builder()
                .title(title)
                .unit(unit)
                .build();
        course.setCreateDate(new Date());
        ApplicationContext.courseRepository.saveOrUpdate(course);
    }

    @Override
    public void updateCourse(Long id, String title, String unit) {
        Course course = Course.builder()
                .title(title)
                .unit(unit)
                .build();
        ApplicationContext.courseRepository.saveOrUpdate(course);
    }

    @Override
    public void deleteCourse(Long id) {
        ApplicationContext.courseRepository.delete(id);
    }


}
