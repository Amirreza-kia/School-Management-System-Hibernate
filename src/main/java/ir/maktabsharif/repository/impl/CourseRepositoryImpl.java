package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl  implements CourseRepository  {

    @Override
    public Optional<Course> findById(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Course course = null;
        try {
            transaction.begin();
            course = em.find(Course.class, id);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(course);
    }

    @Override
    public List<Course> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Course> courses = null;
        try {
            transaction.begin();
            courses = em.createQuery("from Course", Course.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        return courses;
    }

    @Override
    public void persist(Course entity) {
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
    public void update(Course entity) {
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
    public void delete(Course entity) {
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
