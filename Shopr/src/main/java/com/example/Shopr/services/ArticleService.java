package com.example.Shopr.services;

import com.example.Shopr.domain.*;
import com.example.Shopr.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    //ARTICLES
    //Find All Articles

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    //Find Article By ID
    public Article findById(Long id) {
        return articleRepository.findById(id);
    }
    //Optional<Article>

    //Delete Article
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

    //Save Article
    public void save(Article article) {
        articleRepository.save(article);
    }

    //Update Article
    public void update(Article article) {
        articleRepository.update(article);
    }

    //BOOKS
    //Find All Books
    public List<Book> findBooks(){
        return articleRepository.findBooks();
    }

    //Find Book By ID

    public Book findBookById(Long id) {
        return articleRepository.findBookById(id);
    }
    public BookFiction findBookFictionById(Long id) { return articleRepository.findBookFictionById(id);}
    public BookNonFiction findBookNonFictionById(Long id) { return articleRepository.findBookNonFictionById(id);}
    //Delete Book
    public void deleteBook(Long id) {
        articleRepository.deleteBookById(id);
    }
    //GAMES
    //Find All Games
    public List<Game> findGames(){
        return articleRepository.findGames();
    }
    //Find Game By ID
    public Game findGameById(Long id) {
        return articleRepository.findGameById(id);

    }
    //Delete Game
    public void deleteGame(Long id) {
        articleRepository.deleteGameById(id);
    }

    //LP's
    //Find All LP's
    public List<Lp> findLps(){return articleRepository.findLps();
    }
    //Find LP By ID

    public Lp findLpById(Long id) {
        return articleRepository.findLpById(id);

    }
    //Delete Game
    public void deleteLp(Long id) {
        articleRepository.deleteLpById(id);
    }

}
