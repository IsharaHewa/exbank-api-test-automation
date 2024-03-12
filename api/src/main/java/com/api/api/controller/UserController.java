package com.api.api.controller;

import com.api.api.model.User;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("/exbank")
//Contoller for user
public class UserController {
    @Autowired
    private UserService userService;
    private User user;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    //GET user
    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
    //POST user
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        this.user = user;
        return user;
    }
    //PUT user
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        this.user = user;
        return user;
    }
    //DELETE user
    @DeleteMapping("/deleteUser")
    public User updateUser(@RequestParam Integer id){
        return user;
    }
}
