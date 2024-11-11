package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {
    private final EntityManagerProvider entityManagerProvider;

    public TeacherRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }
    @Override
    public Optional<Teacher> findById(long id) {
        return Optional.ofNullable(entityManagerProvider.getEntityManager().find(Teacher.class, id));
    }

    @Override
    public List<Teacher> findAll() {
        return entityManagerProvider.getEntityManager().createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Teacher obj) {
        if (obj.getId() == null) {
            persist(obj);
        }else update(obj);
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Teacher teacher = findById(id).get();
        try {
            transaction.begin();
            entityManager.remove(teacher);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }
    public void persist(Teacher entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }finally {
            entityManager.close();
        }
    }

    public void update(Teacher entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Optional<Teacher> teacher = this.findById(entity.getId());
        if (teacher.isPresent()) {
            try {
               transaction.begin();
               entityManager.merge(entity);
               transaction.commit();

            }catch (Exception e) {
                transaction.rollback();
            }finally {
                entityManager.close();
            }
        }else System.out.println("Teacher not found");

    }
}
