package ir.maktabsharif;

import ir.maktabsharif.menu.Menu;
import ir.maktabsharif.model.model.Course;
import ir.maktabsharif.model.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;
import ir.maktabsharif.repository.impl.TeacherRepositoryImpl;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.EntityManagerProvider;


import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        Menu.startMenu();
    }
}
