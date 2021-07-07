package com.example.Shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "BOOK_NON_FICTION")
@Data
@Entity

//@AllArgsConstructor


public class BookNonFiction extends Book{



    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private Subject subject;
//    @Column(name = "book_genre")
//    private BookGenre bookGenre;
//    @Column(name = "description")
//    private String description;

    public BookNonFiction(){

    }

    @Builder
    public BookNonFiction(Long id, String title, Double price, String supplierId, String author, String isbn, int pages, Subject subject, BookGenre bookGenre, String description) {
        super(id, title, price, supplierId, author, isbn, pages);
        this.subject = subject;
//        this.bookGenre = bookGenre;
//        this.description = description;
    }
}
