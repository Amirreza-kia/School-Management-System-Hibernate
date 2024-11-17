package ir.maktabsharif.thread;

import ir.maktabsharif.model.model.Student;
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
//        int numbers = studentRepository.getStudentCount();
        System.out.println(Thread.currentThread().getName());
        int number = students.size();
        while (true) {
            System.out.println(number);
//            System.out.println(numbers);
            try {
                Thread.sleep(2000,1);
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
