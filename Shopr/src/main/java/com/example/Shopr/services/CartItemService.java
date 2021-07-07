package com.example.Shopr.services;

import com.example.Shopr.domain.Article;
import com.example.Shopr.domain.CartItem;
import com.example.Shopr.domain.User;
import com.example.Shopr.repositories.CartItemRepository;
import com.example.Shopr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserRepository userRepository;



    public List<CartItem> listCartItems(User user){

      return cartItemRepository.findByUser(user);

    }

    //Create CartItem

    public void addArticle(CartItem cartItem) {
        cartItemRepository.addArticle(cartItem);
    }

    public List<CartItem> getCart() {
        return cartItemRepository.getCart();
    }
}
