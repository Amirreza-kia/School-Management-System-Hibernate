package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {
    @Override
    public Optional<Teacher> findById(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Teacher teacher = null;
        try {
            transaction.begin();
            teacher = em.find(Teacher.class, id);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Teacher> teachers = null;
        try {
            transaction.begin();
            teachers = em.createQuery("from Teacher ", Teacher.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        return teachers;
    }

    @Override
    public void persist(Teacher entity) {
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
    public void update(Teacher entity) {
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
    public void delete(Teacher entity) {
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
