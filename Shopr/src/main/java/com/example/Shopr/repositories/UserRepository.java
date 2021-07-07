package com.example.Shopr.repositories;

import com.example.Shopr.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        TypedQuery<User> users = entityManager.createQuery("select u from User u", User.class);
        return users.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void save(User user) {
        entityManager.persist(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void deleteById(long id) {
        User user = findById(id);
        entityManager.remove(user);
    }


}
