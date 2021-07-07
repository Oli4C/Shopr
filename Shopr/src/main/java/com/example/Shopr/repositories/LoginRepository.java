package com.example.Shopr.repositories;

import com.example.Shopr.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository



public class LoginRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        TypedQuery<User> users = entityManager.createQuery("select u from User u", User.class);
        return users.getResultList();
    }
}
