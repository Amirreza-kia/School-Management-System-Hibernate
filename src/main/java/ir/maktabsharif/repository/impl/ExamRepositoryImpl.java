package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.ExamRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ExamRepositoryImpl implements ExamRepository  {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public Optional<Exam> findById(int id) {
        return Optional.ofNullable(entityManager.find(Exam.class, id));
    }

    @Override
    public List<Exam> findAll() {
        return this.entityManager.createQuery("from Exam", Exam.class).getResultList();
    }

    @Override
    public void persist(Exam entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
        }catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }finally {
            this.entityManager.close();
        }
    }

    @Override
    public void update(Exam entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(entity);
            this.entityManager.getTransaction().commit();

        }catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }finally {
            this.entityManager.close();
        }

    }

    @Override
    public void delete(Exam entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entity);
            this.entityManager.getTransaction().commit();
        }catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
        finally {
            this.entityManager.close();
        }

    }
}
