package ir.maktabsharif.repository.impl;

import ir.maktabsharif.util.EntityManagerProvider;
import ir.maktabsharif.model.model.User;
import ir.maktabsharif.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    public UserRepositoryImpl() {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(EntityManagerProvider.getEntityManager().find(User.class, id));
    }

    @Override
    public List<User> findAll() {
       return EntityManagerProvider.getEntityManager().createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveOrUpdate(User obj) {
        if(obj.getId() == null) {
            persist(obj);
        }else update(obj);
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        User user = entityManager.find(User.class, id);
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
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        Query query = entityManager.createQuery("select count(u) from User u");
        query.setMaxResults(1);
        return ((Long)query.getSingleResult()).intValue();
    }
    public void persist(User entity) {
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


    public void update(User entity) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
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
//    public List<Student> findByFirstname(String firstname) {
//        EntityManager entityManager = entityManagerProvider.getEntityManager();
//        TypedQuery<Student> query = entityManager.createNamedQuery("Student.findByFirstname", Student.class);
//        query.setParameter(1, firstname);
//        return query.getResultList();
//
//    }
    @Override
    public Optional<User> login(String username, String password) {
       EntityManager entityManager = EntityManagerProvider.getEntityManager();
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByUsernameAndPassword", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return Optional.ofNullable(query.getSingleResult());
    }
}
