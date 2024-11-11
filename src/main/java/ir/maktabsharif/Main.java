package ir.maktabsharif;

import ir.maktabsharif.menu.Menu;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.model.enums.UserType;
import ir.maktabsharif.repository.TeacherRepository;
import ir.maktabsharif.repository.impl.TeacherRepositoryImpl;
import ir.maktabsharif.util.ApplicationContext;
import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.util.Printer;
import lombok.Builder;


import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerProvider emp = new EntityManagerProvider();
        TeacherRepository teacherRepository = new TeacherRepositoryImpl(emp);




        Menu.startMenu();


        // زمانی که می خواهیم ترنس اکشن ها ئاخل یک بسنه قرار دهیم خودش اگر انجام ندهد به حالت قبل بر مبگردد
        // در حالت های خاص با استفاده از رول بک بر میگردانیم به حالت اولیه نکته مهم این است که بدون رول بک هم بر میگردد مگر در موارد خاص
        // کلا یکبار داخل سویج ها یا ریپازیتوری ها یک بار از کلوز استقده می کنیم
//        try {
//            em.getTransaction().begin();
//            //Operation
//            em.getTransaction().commit();
//        }catch (Exception e) {
//            em.getTransaction().rollback();
//        }


    }
}
