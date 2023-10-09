package com.learningspringboot.webmovieslibrary.moviesapplication.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService){
        super();
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> listUsers(){
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return userService.findOne(id);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteById(id);
    }

    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

}
