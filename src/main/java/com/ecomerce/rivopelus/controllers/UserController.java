package com.ecomerce.rivopelus.controllers;

import com.ecomerce.rivopelus.entities.User;
import com.ecomerce.rivopelus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user){
        return userService.edit(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        userService.deleteById(id);
    }

}
