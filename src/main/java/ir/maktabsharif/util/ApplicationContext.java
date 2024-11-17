package ir.maktabsharif.util;


import ir.maktabsharif.repository.*;
import ir.maktabsharif.repository.impl.*;
import ir.maktabsharif.service.*;
import ir.maktabsharif.service.impl.*;

public class ApplicationContext {
    public static final String[] LOGIN_MENU_ITEM = {"LOGIN USER", "EXIT"};
    public static final String[] ADMIN_MENU_ITEM = {"CREATE COURSE", "UPDATE COURSE", "DELETE COURSE",
            "CREATE TEACHER", "UPDATE TEACHER", "DELETE TEACHER",
            "CREATE STUDENT", "UPDATE STUDENT", "DELETE STUDENT",
            "BACK LAST MENU"};
    public static final String[] STUDENT_MENU_ITEM = {"ASSIGN COURSE", "SEE GPU INFORMATION"
            , "BACK LAST MENU"};
    public static final String[] TEACHER_MENU_ITEM = {"SET SCORE FOR STUDENT","SEE COURSE INFORMATION","BACK LAST MENU"};


    public static CourseRepository courseRepository = new CourseRepositoryImpl();
    public static ExamRepository examRepository = new ExamRepositoryImpl();
    public static UserRepository userRepository = new UserRepositoryImpl();
    public static TeacherRepository teacherRepository = new TeacherRepositoryImpl();
    public static StudentRepository studentRepository = new StudentRepositoryImpl();
    public static CourseService courseService = new CourseServiceImpl();
    public static ExamService examService = new ExamServiceImpl();
    public static StudentService studentService = new StudentServiceImpl();
    public static TeacherService teacherService = new TeacherServiceImpl();
    public static UserService userService = new UserServiceImpl();


}
