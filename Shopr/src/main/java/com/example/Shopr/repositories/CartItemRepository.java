package com.example.Shopr.repositories;

import com.example.Shopr.domain.CartItem;
import com.example.Shopr.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    public List<CartItem> findAll() {
//        TypedQuery<CartItem> cartItem = entityManager.createQuery("select ci from CartItem ci", CartItem.class);
//        return cartItem.getResultList();
//    }

    @Transactional(rollbackOn = Exception.class)
    public void save(CartItem cartItem) {
        entityManager.persist(cartItem);
    }

    public CartItem findById(long id) {
        return entityManager.find(CartItem.class, id);
    }

    @Transactional
    public void update(CartItem cartItem) {
        entityManager.merge(cartItem);
    }

    @Transactional
    public void deleteById(long id) {
        CartItem cartItem = findById(id);
        entityManager.remove(cartItem);
    }

    public List<CartItem> findByUser(User user){
       TypedQuery query = entityManager.createQuery("select ci from CartItem ci where ci.user = ?1", CartItem.class);
        query.setParameter(1, user.getId());

        return query.getResultList();
    }

    //Creat CartItem

    @Transactional(rollbackOn = Exception.class)
    public void addArticle(CartItem cartItem) {
        entityManager.merge(cartItem);
    }

    public List<CartItem> getCart() {
        TypedQuery<CartItem> cartItems = entityManager.createQuery("select ci from CartItem ci",CartItem.class);
        return cartItems.getResultList();
    }
}


