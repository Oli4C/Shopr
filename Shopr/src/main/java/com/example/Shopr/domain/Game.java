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
@DiscriminatorValue(value = "GAME")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "publisher"}))
public class Game extends Article {
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "min_age")
    private int minAge;
    @Enumerated(EnumType.STRING)
    @Column(name = "game_genre")
    private GameGenre gameGenre;

    public Game() {
        }
    @Builder
    public Game(Long id, String title, Double price, String supplierId, String publisher, int minAge, GameGenre gameGenre) {
        super(id, title, price, supplierId);
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }
}
