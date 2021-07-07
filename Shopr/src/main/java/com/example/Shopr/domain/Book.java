package com.example.Shopr.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Data
@Entity

@AllArgsConstructor


public abstract class Book extends Article {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
//    @Pattern(regexp= "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3}) " +
//            "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$) " +
//            "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$" , message = "ISBN must be correctly formatted.")
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "pages")
    private int pages;


    public Book (){

    }


    public Book(Long id, String title, Double price, String supplierId, String author, String isbn, int pages) {
        super(id, title, price, supplierId);

        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }
}
