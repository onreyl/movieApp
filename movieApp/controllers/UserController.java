package com.project.movieApp.controllers;

import com.project.movieApp.entities.User;
import com.project.movieApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getAll(){

        return userService.getAll();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){

        return userService.createUser(newUser);
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Long id){
        //custom exception
        return userService.getOneUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){

        userService.deleteUser(id);
    }
}
