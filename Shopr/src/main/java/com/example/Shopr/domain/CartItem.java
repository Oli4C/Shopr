package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "cart_items")

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
////    @JoinColumn(name = "book_id")
//    private Book book;

    @ManyToOne
//    @JoinColumn(name = "book_fiction_id")
    private BookFiction bookFiction;

    @ManyToOne
//    @JoinColumn(name = "book_non_fiction_id")
    private BookNonFiction bookNonFiction;

    @ManyToOne
//    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
//    @JoinColumn(name = "lp_id")
    private Lp lp;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToOne
    private Orders Orders;

    private int quantity = getQuantity();

    private Double currentPrice;

    private double totalPrice;

    public double getTotalPrice() {
        totalPrice = currentPrice * quantity;
        return totalPrice;
    }



}
