package com.example.Shopr.controllers;

import com.example.Shopr.domain.*;
import com.example.Shopr.services.ArticleService;
import com.example.Shopr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    //ARTICLES
    //Get All Articles

    @GetMapping(value = "allarticles")
    public String showAllProducts(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "allarticle";
    }

    public static Boolean isGame(Article article){
        return article instanceof Game;
    }
    public static Boolean isBook(Article article){
        return article instanceof Book;
    }
    public static Boolean isBookFiction(Article article){
        return article instanceof BookFiction;
    }
    public static Boolean isBookNonFiction(Article article){
        return article instanceof BookNonFiction;
    }
    public static Boolean isLp(Article article){
        return article instanceof Lp;
    }

    //Find Article By ID

    @RequestMapping("allarticles/findById")
    @ResponseBody
    public Article findById(Long id) {  //(Long id, Class<? extends Article> type)
        return articleService.findById(id);
    }


    //Add New Article

    @PostMapping(value = "allarticles/addNew")
    public String addNew(Article article) {
        articleService.save(article);
        return "redirect:/adminindex";
    }


    //BOOKS
    //Get All Books

    @GetMapping(value = "books")
    public String showAllBooks(Model model){
        model.addAttribute("books", articleService.findBooks());
        model.addAttribute("bookGenre", BookGenre.values());
        model.addAttribute("subject", Subject.values());
        return "book";
    }

    //Find Book By Id

    @RequestMapping("books/findById")
    @ResponseBody
    public Book findBookById(Long id) {
        return articleService.findBookById(id);
    }

    //Add New Book Fiction

    @PostMapping(value = "books/addNewBF")
    public String addNew(BookFiction book) {

        articleService.save(book);
        return "redirect:/books";
    }

    //Add New Book NonFiction

    @PostMapping(value = "books/addNewBNF")
    public String addNew(BookNonFiction book) {

        articleService.save(book);
        return "redirect:/books";
    }

    //Update Book Fiction
    @RequestMapping(value="books/updateBF", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update (BookFiction book) {

        articleService.update(book);
        return "redirect:/books";
    }

    //Update Book NonFiction
    @RequestMapping(value="books/updateBNF", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update (BookNonFiction book) {

        articleService.update(book);
        return "redirect:/books";
    }

    //Delete Book
    @RequestMapping(value="books/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteBook(Long id) {
       articleService.deleteBook(id);
        return "redirect:/books";
    }

    //GAMES
    //Get All Games

    @GetMapping(value = "games")
    public String showAllGames(Model model){
        model.addAttribute("games", articleService.findGames());
        model.addAttribute("gameGenre", GameGenre.values());
        return "game";
    }

    //Find Game By ID
    @RequestMapping("games/findById")
    @ResponseBody
    public Game findGameById(Long id) {
        return articleService.findGameById(id);
    }

    //Add New Game

    @PostMapping(value = "games/addNew")
    public String addNew(Game game) {

        articleService.save(game);
        return "redirect:/games";
    }

    //Update Game
    @RequestMapping(value="games/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update (Game game) {

        articleService.update(game);
        return "redirect:/games";
    }
    //Delete Game
    @RequestMapping(value="games/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteGame(Long id) {
        articleService.deleteGame(id);
        return "redirect:/games";
    }
    //LP's
    //Get All Lp's
    @GetMapping(value = "lps")
    public String showAllLps(Model model){
        model.addAttribute("lps", articleService.findLps());
        model.addAttribute("lpGenre", LpGenre.values());
        return "lp";
    }

    //Find LP By ID
    @RequestMapping("lps/findById")
    @ResponseBody
    public Lp findLpById(Long id) {
        return articleService.findLpById(id);
    }

    //Add New LP

    @PostMapping(value = "lps/addNew")
    public String addNew(Lp lp) {

        articleService.save(lp);
        return "redirect:/lps";
    }

    //Update LP
    @RequestMapping(value="lps/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update (Lp lp) {

        articleService.update(lp);
        return "redirect:/lps";
    }

    //Delete LP
    @RequestMapping(value="lps/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteLp(Long id) {
        articleService.deleteLp(id);
        return "redirect:/lps";
    }

    //USERS
    //Get All Users
    @GetMapping("users")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());

        return "user";
    }
    //Find User By ID
    @RequestMapping("users/findById")
    @ResponseBody
    public User findUserById(Long id)
    {
        return userService.findById(id);
    }

    //Add User
    @PostMapping(value="users/addNew")
    public String addNew(User user) {
        userService.save(user);
        return "redirect:/users";
    }
    //Update User
    @RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }
    //Delete User
    @RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
