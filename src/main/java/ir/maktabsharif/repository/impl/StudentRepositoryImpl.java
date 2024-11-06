package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(this.entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> findAll() {
        return this.entityManager.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public void persist(Student entity) {
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
    public void update(Student entity) {
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
    public void delete(Student entity) {
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
