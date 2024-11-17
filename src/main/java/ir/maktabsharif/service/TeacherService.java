package ir.maktabsharif.service;

import ir.maktabsharif.model.model.Teacher;

public interface TeacherService {
    void addTeacher(String firstName, String lastName, String nationalCode,String username, String password, Long course_id,String Gender);
}
