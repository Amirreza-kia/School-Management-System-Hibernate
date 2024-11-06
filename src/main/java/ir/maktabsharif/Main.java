package ir.maktabsharif;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.StudentRepository;
import ir.maktabsharif.repository.impl.StudentRepositoryImpl;
import ir.maktabsharif.thread.FirstThread;
import ir.maktabsharif.tut.Account;
import org.hibernate.Hibernate;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(); {
        }
        Thread thread = new Thread(new FirstThread(studentRepository));
        thread.start();
        thread.setPriority(1);



//
//        Thread thread = new Thread(new FirstThread());
//        System.out.println(Thread.currentThread().getName());
//
//        {
//            Thread.sleep(2222, 2);
//        }
//        thread.start();
//        thread.join();














        // decrease user balance = operation one
//        {
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
//            EntityManager em = emf.createEntityManager();
//
//            emf.close();
//        }










//        begin و کامیت یک بار اول و اخر میزاریم نیازی مثل پایین رفتار کنیم
//        int userInput = new Scanner(System.in).nextInt();
//        try{
//            em.getTransaction().begin();
//            {
//                Account accountOne =  Account.builder().balance(1000l).build();
//                em.persist(accountOne);
//                Account accountTwo = Account.builder().balance(2000l).build();
//                em.persist(accountTwo);
//                em.getTransaction().commit();
//            }
//        }catch (Exception e){
//            em.getTransaction().rollback();
//        }
//        em.close();


//        {
//            Student student = Student
//                    .builder()
//                    .first_name("amirreza")
//                    .lastname("kia").build();
//            em.getTransaction().begin();
//            em.persist(student);
//            em.getTransaction().commit();
////            em.close();
//        }
//        {
//            Teacher teacher = Teacher
//                    .builder()
//                    .firstName("ali")
//                    .lastName("najafi").build();
//            em.getTransaction().begin();
//            em.persist(teacher);
//            em.getTransaction().commit();
////            فقط یکبار در کلاس از متود زیر استفاده می کنیم
//            em.close();
//        }

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
