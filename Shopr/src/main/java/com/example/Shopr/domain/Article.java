package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@DiscriminatorColumn(name = "type")
@Data

@AllArgsConstructor

public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
    @Column(name = "supplier_id")
    private String supplierId;

    public Article(){

    }

    public Article(Long id, String title, Double price, String supplierId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
    }
}
