package com.example.doctoral.service;

import com.example.doctoral.entity.Address;
import com.example.doctoral.entity.Role;
import com.example.doctoral.entity.User;
import com.example.doctoral.repo.AddressRepo;
import com.example.doctoral.repo.RoleRepo;
import com.example.doctoral.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static com.example.doctoral.configuration.JwtRequestFilter.CURRENT_USER;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final AddressRepo addressRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user){
        Role role=roleRepo.findById("user").get();
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        Address address=addressRepo.save(user.getAddress());
        user.setAddress(address);
        return userRepo.save(user);
    }

    public User registerNewAdminUser(User user){
//        Role role=roleRepo.findById("committee").get();
//        Set<Role> roles=new HashSet<>();
//        roles.add(role);
//        user.setRole(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        Address address=addressRepo.save(user.getAddress());
        user.setAddress(address);
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public Number getAllStudentsCount(){
        return userRepo.findAllUserCount();
    }

    public Number getPreAllStudentsCount(){
        return userRepo.findAllPreUserCount();
    }

    public Number getAllStudentsStatusCount(String status){
        return userRepo.findAllStatusCount(status);
    }

    public Number getAllPreSelectedStudentsCount(){
        return userRepo.findAllPreSelectedUserCount();
    }


    public List<User> getAllStudents(){
        return userRepo.findAllUser();
    }

    public void initDefaultRolesAndAdminUser(){
        User user=new User();
        Role role=roleRepo.findById("super_admin").get();
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setPhone("07438867659");
        user.setEmail("doctoralphdapplication@gmail.com");
        user.setName("saleeh");
        user.setPassword(getEncodedPassword("abc123"));
        Address address=new Address();
        address.setId(1);
        address.setAddress_line1("1");
        address.setAddress_line2("Empire Student Hall");
        address.setStreet("Haywood Street");
        address.setPostcode("ST4 2RB");
        address.setTown("Stoke-on-Trent");



        address.setCountry("United Kingdom");
        address.setCounty("Staffordshire");
        user.setAddress(address);
        userRepo.save(user);

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

    public User getUserByUserName(){
        return userRepo.findById(CURRENT_USER).get();
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
