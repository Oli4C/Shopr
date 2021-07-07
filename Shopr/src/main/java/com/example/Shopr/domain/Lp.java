package com.example.Shopr.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data

//@AllArgsConstructor

@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "LP")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "artist"}))
public class Lp extends Article {
    @Column(name = "artist")
    private String artist;
    @Enumerated(EnumType.STRING)
    @Column(name = "lp_genre")
    private LpGenre lpGenre;

    public Lp(){

    }


    @Builder
    public Lp(Long id, String title, Double price, String supplierId, String artist, LpGenre lpGenre) {
        super(id, title, price, supplierId);
        this.artist = artist;
        this.lpGenre = lpGenre;
    }

}
