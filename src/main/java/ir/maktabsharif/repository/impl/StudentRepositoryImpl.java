package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

//

public class StudentRepositoryImpl implements StudentRepository {
    private final EntityManagerProvider entityManagerProvider;

    public StudentRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    //--------------------------------------------------
    @Override
    public int getStudentCount() {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(s) FROM Student s", Student.class);
        return ((Long) query.getSingleResult()).intValue();
    }

    //--------------------------------------------------
    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(entityManagerProvider.getEntityManager().find(Student.class, id));
    }

    //--------------------------------------------------
    @Override
    public List<Student> findAll() {
        return entityManagerProvider.getEntityManager().createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    //--------------------------------------------------
    @Override
    public void saveOrUpdate(Student obj) {
        if (obj.getId() == null) {
            persist(obj);
        } else update(obj);

    }

    //--------------------------------------------------
    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Student student = findById(id).get();
        try {
            transaction.begin();
            entityManager.remove(student);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    //--------------------------------------------------
    public void persist(Student entity) {
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
    public void update(Student entity) {
        Optional<Student> studentOptional = this.findById(entity.getId());
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        if (studentOptional.isPresent()) {
//            studentOptional.get().setFirstname(entity.getFirstname());
            try {
                transaction.begin();
                entityManager.merge(entity);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            } finally {
                entityManager.close();
            }
        }
    }

    //--------------------------------------------------
    public List<Student> findByFirstname(String firstname) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByFirstname", Student.class);
        query.setParameter(1, firstname);
        return query.getResultList();

    }
}
