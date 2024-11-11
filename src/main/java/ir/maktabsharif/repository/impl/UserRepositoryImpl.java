package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.User;
import ir.maktabsharif.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManagerProvider entityManagerProvider;
    public UserRepositoryImpl(EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(entityManagerProvider.getEntityManager().find(User.class, id));
    }

    @Override
    public List<User> findAll() {
       return entityManagerProvider.getEntityManager().createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveOrUpdate(User obj) {
        if(obj.getId() == null) {
            persist(obj);
        }else update(obj);
    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User user = findById(id).get();
        try {
            transaction.begin();
            entityManager.remove(user);
            transaction.commit();
        }catch(Exception e) {
            transaction.rollback();
        }finally {
            entityManager.close();
        }

    }

    public int getCountUser(){
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery("select count(u) from User u");
        query.setMaxResults(1);
        return ((Long)query.getSingleResult()).intValue();
    }
    public void persist(User entity) {
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


    public void update(User entity) {
        EntityManager entityManager = entityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Optional<User> user = this.findById(entity.getId());
        if(user.isPresent()) {
            try {
                transaction.begin();
                entityManager.merge(entity);
                transaction.commit();
            }catch (Exception e) {
               transaction.rollback();
            }finally {
                entityManager.close();
            }
        }else System.out.println("user not found");
    }
}
