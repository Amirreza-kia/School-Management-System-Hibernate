package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.ExamRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class ExamRepositoryImpl implements ExamRepository  {
    @Override
    public Optional<Exam> findById(int id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Exam exam = null;
        try {
            transaction.begin();
            exam = em.find(Exam.class, id);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return Optional.ofNullable(exam);
    }

    @Override
    public List<Exam> findAll() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        List<Exam> exams = null;
        try {
            transaction.begin();
            exams = em.createQuery("from Exam ", Exam.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
        return exams;
    }

    @Override
    public void persist(Exam entity) {
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
    public void update(Exam entity) {
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
    public void delete(Exam entity) {
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
