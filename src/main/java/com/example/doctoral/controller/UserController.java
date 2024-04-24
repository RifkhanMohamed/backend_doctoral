package com.example.doctoral.controller;

import com.example.doctoral.entity.User;
import com.example.doctoral.repo.UserRepo;
import com.example.doctoral.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    @Autowired
    private UserRepo userRepo;
    @PostMapping(path = "/register")
    public User registerNewUser(@RequestBody User user){

        if(userRepo.findByEmail(user.getEmail())!=null)
        {
            throw new RuntimeException("This email already exist!");
        }
        return userService.registerNewUser(user);
    }
}
