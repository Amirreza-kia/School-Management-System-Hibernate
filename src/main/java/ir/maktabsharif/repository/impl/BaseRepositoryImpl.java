package ir.maktabsharif.repository.impl;

import ir.maktabsharif.Utill.EntityManagerProvider;
import ir.maktabsharif.repository.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.MappedSuperclass;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseRepositoryImpl  {

//    private final EntityManagerProvider entityManagerProvider;
//
//    public BaseRepositoryImpl(EntityManagerProvider entityManagerProvider) {
//        this.entityManagerProvider = entityManagerProvider;
//    }
//    @Override
//    public void persist(Object entity)  {
//
//    }
//
//    @Override
//    public Optional findById(int id)  {
//        return Optional.empty();
//    }
//
//    @Override
//    public List findAll()  {
//        return List.of();
//    }
//
//
//
//    @Override
//    public void update(Object entity)  {
//        EntityManager em = EntityManagerProvider.getEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        try {
//            transaction.begin();
//            em.merge(entity);
//            transaction.commit();
//        }catch (Exception e) {
//            transaction.rollback();
//        }finally {
//            em.close();
//        }
//
//    }
//
//    @Override
//    public void delete(int id)  {
//        EntityManager em = EntityManagerProvider.getEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        try {
//            transaction.begin();
//            em.remove(id);
//            transaction.commit();
//        }catch (Exception e) {
//            transaction.rollback();
//        }finally {
//            em.close();
//        }
//
//    }
}
