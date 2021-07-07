package com.example.Shopr.controllers;

import com.example.Shopr.domain.CartItem;
import com.example.Shopr.domain.Orders;
import com.example.Shopr.domain.User;
import com.example.Shopr.services.LoginService;
import com.example.Shopr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLogin(HttpSession session, Model model) {
        model.addAttribute("users", loginService.getUsers());
        if (session.getAttribute("loggedInUser") == null){
            session.setAttribute("loggedInUser", new User() );
        }
    return "login";
    }

    @PostMapping(path = "/login")
    public String showLoginPage(@ModelAttribute("loggedInUser") User user, Model model, HttpSession session) {
    user = userService.findById(user.getId());
        session.setAttribute("loggedInUser", user );
        if (user.getUserName() != null && loginService.login(user.getUserName(), user.getPassword())) {

            if (user.getUserName().equals("Admin") && user.getPassword().equals("Admin")) {

                return "redirect:/adminindex";
            } else{
                Orders orders =  new Orders();
                orders.setUser(user);
                session.setAttribute("order", orders);
//                new Orders().getCartItems().add(new CartItem());


                return "redirect:/shopindex";

            }

        } else return "redirect:/";
    }

        @PostMapping(path = "/newUser")
        public String newUsers (Model model){
            model.addAttribute("newWebUser", new User());
            return "login";
        }
        @GetMapping("/adminindex")
        public String goAdminHome () {
            return "adminindex";
        }

        @GetMapping("/shopindex")
        public String goShopHome () {
            return "shopindex";
        }
    @GetMapping("/logout")
    public String logout () {
        return "redirect:/";
    }

    }
