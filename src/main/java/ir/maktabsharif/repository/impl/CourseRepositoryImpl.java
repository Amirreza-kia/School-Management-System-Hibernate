package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.repository.CourseRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl  implements CourseRepository  {
    EntityManager entityManager = EntityManagerProvider.getEntityManager();
    @Override
    public Optional<Course> findById(int id) {
        return Optional.ofNullable(this.entityManager.find(Course.class, id));
    }

    @Override
    public List<Course> findAll() {
        return this.entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public void persist(Course entity) {
        try {
           this.entityManager.getTransaction().begin();
           this.entityManager.persist(entity);
           this.entityManager.getTransaction().commit();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }finally {
            this.entityManager.close();
        }

    }

    @Override
    public void update(Course entity) {
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
    public void delete(Course entity) {
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

        //Query query = entityManager.createQuery("select c from Course c");

    }
}
