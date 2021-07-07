package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = CartItem.class)
    private List<CartItem> cartItems;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    private Boolean isPayed = false;

}
