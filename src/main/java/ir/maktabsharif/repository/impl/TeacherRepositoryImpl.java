package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.model.Teacher;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {


    public TeacherRepositoryImpl() {

    }
    @Override
    public Optional<Teacher> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(Teacher.class, id));


    }

    @Override
    public List<Teacher> findAll() {
        return EntityManagerProvider.getEntityManager().createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Teacher obj) {
        if (obj.getId() == null) {
            persist(obj);
        }else update(obj);
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Teacher teacher = entityManager.find(Teacher.class, id);
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
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
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
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
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
