package ir.maktabsharif.service;

import java.util.Date;

public interface CourseService {
    void addCourse (String title, String unit);
    void updateCourse (Long id,String title, String unit);
    void deleteCourse (Long id);

}
