package ir.maktabsharif.thread;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

import java.util.List;

public class FirstThread implements Runnable {

    StudentRepository studentRepository;
    public FirstThread(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run() {
        List<Student> students = studentRepository.findAll();
        int number = students.size();
        while (true) {
            System.out.println(number);
            try {
                Thread.sleep(13422,1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            studentRepository.findAll();
        }

    }


//        Thread thread = new Thread(this);
//        try {
//            Thread.sleep(2222);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Thread.currentThread().getName());


}
