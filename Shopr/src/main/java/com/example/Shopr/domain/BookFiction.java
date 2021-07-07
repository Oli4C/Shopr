package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "BOOK_FICTION")
@Data
@Entity

//@AllArgsConstructor


public class BookFiction extends Book {



    @Enumerated (EnumType.STRING)
    @Column(name = "book_genre")
    private BookGenre bookGenre;
    @Column(name = "description")
    private String description;
//    @Column(name = "subject")
//    private Subject subject;

    public BookFiction(){

    }

    @Builder
    public BookFiction(Long id, String title, Double price, String supplierId, String author, String isbn, int pages, BookGenre bookGenre, String description, Subject subject) {
        super(id, title, price, supplierId, author, isbn, pages);
        this.bookGenre = bookGenre;
        this.description = description;
//        this.subject = subject;
    }
}
