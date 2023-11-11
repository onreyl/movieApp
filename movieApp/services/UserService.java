package com.project.movieApp.services;

import com.project.movieApp.entities.User;
import com.project.movieApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public List<User> getAll(){

        return userRepository.findAll();
    }

    public User createUser(User newUser){

        return userRepository.save(newUser);
    }

    public User getOneUser(Long id){

        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User newUser) {

        return userRepository.findById(id).map(user -> {
                user.setUserName(newUser.getUserName());
                user.setPassword(newUser.getPassword());
                return userRepository.save(user);
        }).orElse(null);
    }

    public void deleteUser(@PathVariable Long id){

        userRepository.deleteById(id);
    }

}
