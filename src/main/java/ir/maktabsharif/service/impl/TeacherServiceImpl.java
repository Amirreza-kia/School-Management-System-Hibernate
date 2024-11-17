package ir.maktabsharif.service.impl;

import ir.maktabsharif.model.enums.Gender;
import ir.maktabsharif.model.enums.UserType;
import ir.maktabsharif.model.model.Course;
import ir.maktabsharif.model.model.Teacher;
import ir.maktabsharif.service.TeacherService;
import ir.maktabsharif.util.ApplicationContext;

import java.util.Optional;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public void addTeacher(String firstName, String lastName, String nationalCode, String username, String password, Long course_id, String gender) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(firstName);
        teacher.setLastname(lastName);
        teacher.setNationalCode(nationalCode);
        teacher.setUserName(username);
        teacher.setPassword(password);
        Gender gender1 = Gender.valueOf(gender.toUpperCase());
        teacher.setGender(gender1);
        Course course = ApplicationContext.courseRepository.findById(course_id).get();
        teacher.setCourse(course);
        teacher.setUserType(UserType.TEACHER);
        ApplicationContext.teacherRepository.saveOrUpdate(teacher);
    }
}
