package com.example.Shopr.services;

import com.example.Shopr.domain.User;
import com.example.Shopr.repositories.LoginRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Getter
    private static boolean loggedIn;

    public boolean login(String userName, String password){
        loggedIn = userName.equals(password);
        return loggedIn;
    }

    public List<User> getUsers(){
        return loginRepository.getUsers();
    }
}
