package com.example.Shopr.controllers;

import com.example.Shopr.domain.*;
import com.example.Shopr.services.ArticleService;
import com.example.Shopr.services.CartItemService;
import com.example.Shopr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShopController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private UserService userService;

    //ARTICLES
    //Get All Articles

    @GetMapping(value = "allshoparticles")
    public String showAllProducts(Model model){
        model.addAttribute("articles", articleService.findAll());
        return "allshoparticle";
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

//    Find Article By ID

    @RequestMapping("allshoparticles/findById")
    @ResponseBody
    public Article findById(Long id) {  //(Long id, Class<? extends Article> type)
        return articleService.findById(id);
    }

    //BOOKS
    //Get All Books

    @GetMapping(value = "shopbooks")
    public String showAllBooks(Model model){
        model.addAttribute("books", articleService.findBooks());
        model.addAttribute("bookGenre", BookGenre.values());
        model.addAttribute("subject", Subject.values());
        model.addAttribute("bookFiction", new BookFiction());
        model.addAttribute("bookNonFiction", new BookNonFiction());

        model.addAttribute("books", articleService.findBooks());

        return "shopbook";
    }

    //Find Book By Id

    @RequestMapping("shopbooks/findById")
    @ResponseBody
    public Book findBookById(Long id, Model model) {
        model.addAttribute("bookFiction", new BookFiction());
        model.addAttribute("bookNonFiction", new BookNonFiction());

        return articleService.findBookById(id);

    }

    //Order Book

    @RequestMapping(value = "shopbooks/orderBF", method = {RequestMethod.POST, RequestMethod.GET})
    public String orderBookFiction(Model model, int quantity, double price, @ModelAttribute("loggedInUser") User user, BookFiction bookFiction, BookNonFiction bookNonFiction) {
        CartItem cartItem = new CartItem();
        model.addAttribute("loggedInUser", user );
//        if (model.addAttribute("bookFiction", bookFiction).equals(true)) {
//            articleService.findBookById(bookFiction.getId());
//            cartItem.setBookFiction(bookFiction);
//    } else if (model.addAttribute("bookNonFiction", bookFiction ).equals(true)) {
//            articleService.findBookById(bookNonFiction.getId());
//            cartItem.setBookNonFiction(bookNonFiction);
//        }

//        if (isBookFiction(bookFiction)) {
//
//            articleService.findBookById(bookFiction.getId());
//
//            cartItem.setBookFiction(bookFiction);
//
//        } else if (isBookNonFiction(bookNonFiction)){
//
//
//                articleService.findBookById(bookNonFiction.getId());
//                cartItem.setBookNonFiction(bookNonFiction);
//        }


//        User user1 = userService.findById(user.getId());
        BookFiction bookFiction1 = articleService.findBookFictionById(bookFiction.getId());;

        cartItem.setBookFiction(bookFiction1);
        cartItem.setQuantity(quantity);
        cartItem.setCurrentPrice(price);
//        cartItem.setUser(user);
        cartItemService.addArticle(cartItem);

        return "redirect:/shopbooks";
    }

    @RequestMapping(value = "shopbooks/orderBNF", method = {RequestMethod.POST, RequestMethod.GET})
    public String orderBookNonFiction(Model model, int quantity, double price, @ModelAttribute("loggedInUser") User user, BookNonFiction bookNonFiction) {
        CartItem cartItem = new CartItem();
//        user.setUserName(userService.findById(user.getId()).getUserName());
        model.addAttribute("loggedInUser", user );
//        User user1 = userService.findById(user.getId());
        BookNonFiction bookNonFiction1 = articleService.findBookNonFictionById(bookNonFiction.getId());

        cartItem.setBookNonFiction(bookNonFiction1);
        cartItem.setQuantity(quantity);
        cartItem.setCurrentPrice(price);
//        cartItem.setUser(user);
        cartItemService.addArticle(cartItem);

        return "redirect:/shopbooks";
    }

    //GAMES
    //Get All Games

    @GetMapping(value = "shopgames")
    public String showAllGames(Model model){
        model.addAttribute("games", articleService.findGames());
        model.addAttribute("gameGenre", GameGenre.values());
        model.addAttribute("newGameCartItem",new CartItem());

        return "shopgame";
    }

    //Find Game By ID
    @RequestMapping("shopgames/findById")
    @ResponseBody
    public Game findGameById(Long id) {

        return articleService.findGameById(id);
    }


    //Order Game

    @RequestMapping(value = "shopgames/order", method = {RequestMethod.POST, RequestMethod.GET})
    public String orderGame(Game game, int quantity, double price, @ModelAttribute("loggedInUser") User user, Model model){

        model.addAttribute("loggedInUser", user );
//        User user1 = userService.findById(user.getId());
        Game game1 = articleService.findGameById(game.getId());
        CartItem cartItem = new CartItem();
        cartItem.setGame(game1);
        cartItem.setQuantity(quantity);
        cartItem.setCurrentPrice(price);
//        cartItem.setUser(user);
        cartItemService.addArticle(cartItem);

    return "redirect:/shopgames";
    }



    //LP's
    //Get All Lp's
    @GetMapping(value = "shoplps")
    public String showAllLps(Model model){
        model.addAttribute("lps", articleService.findLps());
        model.addAttribute("lpGenre", LpGenre.values());
        return "shoplp";
    }

    //Find LP By ID
    @RequestMapping("shoplps/findById")
    @ResponseBody
    public Lp findLpById(Long id) {
        return articleService.findLpById(id);
    }

    // Order LP

    @RequestMapping(value = "shoplps/order", method = {RequestMethod.POST, RequestMethod.GET})
    public String orderLp(Model model, Lp lp, int quantity, double price, @ModelAttribute("loggedInUser") User user){
        model.addAttribute("loggedInUser", user );
//        User user1 = userService.findById(user.getId());
        Lp lp1 = articleService.findLpById(lp.getId());
        CartItem cartItem = new CartItem();
        cartItem.setLp(lp1);
        cartItem.setQuantity(quantity);
        cartItem.setCurrentPrice(price);
//        cartItem.setUser(user);
        cartItemService.addArticle(cartItem);

        return "redirect:/shoplps";
    }

    @GetMapping(value = "shoppingcart")
    public String shoppingCart(Model model){
        model.addAttribute("cart",cartItemService.getCart());
        return "shoppingcart";
    }

}
