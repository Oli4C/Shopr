package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

//    private boolean loggedIn;
//
//    private boolean admin;


//    @OneToMany (cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
//    private List<CartItem> cartItemList;
}
