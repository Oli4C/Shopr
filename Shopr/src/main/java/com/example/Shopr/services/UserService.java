package com.example.Shopr.services;

import com.example.Shopr.domain.User;
import com.example.Shopr.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Get All Users
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Get User By Id
    public User findById(long id) {
        return userRepository.findById(id);
    }

    //Delete User
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    //Save User
    public void save(User user) {
        userRepository.save(user);
    }

    //Update User
    @Transactional
    public void update(User user) {
        userRepository.update(user);
    }


}
