package com.example.Shopr.repositories;

import com.example.Shopr.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    //ARTICLES
    //Find All Articles

    public List<Article> findAll() {
        List <Article> articles = new ArrayList<>();
        articles.addAll(entityManager.createQuery("select bf from BookFiction bf order by bf.title, bf.price", BookFiction.class).getResultList());
        articles.addAll(entityManager.createQuery("select bnf from BookNonFiction bnf order by bnf.title, bnf.price", BookNonFiction.class).getResultList());
        articles.addAll(entityManager.createQuery("select g from Game g order by g.title, g.price", Game.class).getResultList());
        articles.addAll(entityManager.createQuery("select lp from Lp lp order by lp.title, lp.price", Lp.class).getResultList());


        return articles;
    }

    //Find Article By ID
    public Article findById(Long id){
        return entityManager.find(Article.class, id);
    }

    //Save Article
    @Transactional(rollbackOn = Exception.class)
    public void save(Article article){
        entityManager.persist(article);
    }

    //Update Article
    @Transactional
    public void update(Article article) {
        entityManager.merge(article);
    }

    //Delete Article
    @Transactional
    public void deleteById(Long id) {
        Article article = findById(id);
        entityManager.remove(article);
    }

    //BOOKS
    //Find All Books

    public List<Book> findBooks() {
        List <Book> books = new ArrayList<>();
        books.addAll(entityManager.createQuery("select bf from BookFiction bf order by bf.title, bf.author, bf.price", BookFiction.class).getResultList());
        books.addAll(entityManager.createQuery("select bnf from BookNonFiction bnf order by bnf.title, bnf.author, bnf.price", BookNonFiction.class).getResultList());

        return books;
    }

    //Find Book By ID

    public Book findBookById(Long id){
        return entityManager.find(Book.class, id);
    }

    public BookFiction findBookFictionById(Long id) {return entityManager.find(BookFiction.class, id);}
    public BookNonFiction findBookNonFictionById(Long id) {return entityManager.find(BookNonFiction.class, id);}

    //Delete Book
    @Transactional
    public void deleteBookById(Long id) {
        Book book = findBookById(id);
        entityManager.remove(book);
    }

//    //Filter Books
//    @Query(value = "select * from book b where b.book_genre like %:keyword%", nativeQuery = true)
//        return List <Book> findByGenre(@Param("bookGenre") BookGenre bookGenre);


    //GAMES
    //Find All Games
    public List<Game> findGames() {
        List <Game> games = new ArrayList<>();
        games.addAll(entityManager.createQuery("select g from Game g order by g.title, g.publisher, g.price", Game.class).getResultList());

        return games;
    }
    //Find Game By ID
    public Game findGameById(Long id){
        return entityManager.find(Game.class, id);
    }
    //Delete Game
    @Transactional
    public void deleteGameById(Long id) {
        Game game = findGameById(id);
        entityManager.remove(game);
    }

    //LP's
    //Find All LP's
    public List<Lp> findLps() {
        List <Lp> lps = new ArrayList<>();
        lps.addAll(entityManager.createQuery("select lp from Lp lp order by lp.title, lp.artist, lp.price", Lp.class).getResultList());

        return lps;
    }

    //Find LP By ID

    public Lp findLpById(Long id){
        return entityManager.find(Lp.class, id);
    }

    //Delete Game
    @Transactional
    public void deleteLpById(Long id) {
        Lp lp = findLpById(id);
        entityManager.remove(lp);
    }


}
