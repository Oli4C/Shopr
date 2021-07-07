package com.example.Shopr;

import com.example.Shopr.domain.Article;
import com.example.Shopr.domain.Game;
import com.example.Shopr.domain.Lp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoprApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoprApplication.class, args);
	}

}


//	public List<Article> findAll() {
//		List <Article> articles = new ArrayList<>();
//		articles.addAll(entityManager.createQuery("select g.id, g.type, g.title, g.price, g.supplierId, g.publisher, g.minAge, g.gameGenre from Game g", Game.class).getResultList());
//		articles.addAll(entityManager.createQuery("select lp.id, lp.type, lp.title, lp.price, lp.supplierId, lp.artist, lp.lpGenre from Lp lp", Lp.class).getResultList());
//		articles.addAll(entityManager.createQuery("select b.id, b.type, b.title, b.price, b.supplierId, b.author, b.isbn, b.pages  from Book b", Book.class).getResultList());
//
//		return articles;
//	}