package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.Course;
import ir.maktabsharif.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;



public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManagerProvider entityManagerProvider;
    public CourseRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    //--------------------------------------------------
    @Override
    public Optional<Course> findById(long id) {
        return Optional.ofNullable(entityManagerProvider.getEntityManager().find(Course.class, id));
    }

    //--------------------------------------------------
    @Override
    public List<Course> findAll() {
        return entityManagerProvider.getEntityManager().createQuery("from Course", Course.class).getResultList();
    }

    //--------------------------------------------------
    @Override
    public void saveOrUpdate(Course obj) {
        if (obj.getId() == null) {
            persist(obj);
        } else update(obj);
    }

    //--------------------------------------------------
    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Course course = findById(id).get();

        try {
            transaction.begin();
            entityManager.remove(course);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    //--------------------------------------------------
    public void persist(Course entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    //--------------------------------------------------
    public void update(Course entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Optional<Course> course = findById(entity.getId());
        if (course.isPresent()) {
            try {
                transaction.begin();
                entityManager.merge(entity);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            } finally {
                entityManager.close();
            }
        }else System.out.println("Course not found");

    }
}
