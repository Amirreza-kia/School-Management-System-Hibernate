package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public Optional<Student> findById(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Student student = null;
        try {
            transaction.begin();
            student = em.find(Student.class, id);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Student> students = null;
        try {
            transaction.begin();
            students = em.createQuery("from Student ", Student.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        return students;
    }

    @Override
    public void persist(Student entity) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }
    }

    @Override
    public void update(Student entity) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();

        }catch (Exception e) {
            transaction.rollback();
        }finally {
            em.close();
        }

    }

    @Override
    public void delete(Student entity) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(entity);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }
        finally {
            em.close();
        }

    }
}
