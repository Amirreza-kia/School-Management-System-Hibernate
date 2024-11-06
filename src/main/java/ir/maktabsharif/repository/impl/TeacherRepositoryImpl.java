package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public Optional<Teacher> findById(int id) {
        return Optional.ofNullable(this.entityManager.find(Teacher.class, id));
    }

    @Override
    public List<Teacher> findAll() {
        return this.entityManager.createQuery("from Teacher", Teacher.class).getResultList();
    }

    @Override
    public void persist(Teacher entity) {
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
    public void update(Teacher entity) {
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
    public void delete(Teacher entity) {
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
