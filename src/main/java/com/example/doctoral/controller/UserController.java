package com.example.doctoral.controller;

import com.example.doctoral.entity.User;
import com.example.doctoral.repo.UserRepo;
import com.example.doctoral.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

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

    @PostMapping(path = "/admin/register")
    public User registerNewAdminUser(@RequestBody User user){

        if(userRepo.findByEmail(user.getEmail())!=null)
        {
            throw new RuntimeException("This email already exist!");
        }
        return userService.registerNewAdminUser(user);
    }
    @GetMapping(path = "/get/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "/get/users/count")
    public Number getAllStudentsCount(){
        return userService.getAllStudentsCount();
    }

    @GetMapping(path = "/get/preUsers/count")
    public Number getAllPreStudentsCount(){
        return userService.getPreAllStudentsCount();
    }

    @GetMapping(path = "/get/users/count/status/{status}")
    public Number getAllPreStudentsCount(@PathVariable String status){
        return userService.getAllStudentsStatusCount(status);
    }

    @GetMapping(path = "/get/preSelectedUsers/count")
    public Number getAllPreSelectedStudentsCount(){
        return userService.getAllPreSelectedStudentsCount();
    }



    @GetMapping(path = "/get/all/students")
    public List<User> getAllStudents(){
        return userService.getAllStudents();
    }

    @PostConstruct
    public void initDefaultAdminUser(){
        userService.initDefaultRolesAndAdminUser();
    }
}
