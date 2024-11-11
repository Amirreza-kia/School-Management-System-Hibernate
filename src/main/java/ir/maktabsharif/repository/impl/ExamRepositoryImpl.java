package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.Exam;
import ir.maktabsharif.repository.ExamRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;



public class ExamRepositoryImpl implements ExamRepository  {
    private final EntityManagerProvider entityManagerProvider;
    public ExamRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }
    @Override
    public Optional<Exam> findById(long id) {
        return Optional.ofNullable(entityManagerProvider.getEntityManager().find(Exam.class, id));
    }

    @Override
    public List<Exam> findAll() {
       return entityManagerProvider.getEntityManager().createQuery("select e from Exam e", Exam.class).getResultList();
    }

    @Override
    public void saveOrUpdate(Exam obj) {
        if(obj.getId() == null) {
            persist(obj);
        }else update(obj);
    }


    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Exam exam = findById(id).get();
        try {
            transaction.begin();
            entityManager.remove(exam);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
        }
        finally {
            entityManager.close();
        }

    }
    public void persist(Exam entity) {
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


    public void update(Exam entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Optional<Exam> exam = findById(entity.getId());
        if(exam.isPresent()) {
            try {
                transaction.begin();
                entityManager.merge(entity);
                transaction.commit();
            }catch (Exception e) {
                transaction.rollback();
            }finally {
                entityManager.close();
            }
        }else System.out.println("No exam found");

    }
}
