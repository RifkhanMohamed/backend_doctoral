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

//    public void initDefaultRolesAndAdminUser(){
//        Role adminRole=new Role();
//        adminRole.setRole_name("admin");
//        adminRole.setDescription("admin role for doctoral application");
//        roleRepo.save(adminRole);
//
//        Role userRole=new Role();
//        userRole.setRole_name("user");
//        userRole.setDescription("user role for default role in green product application");
//        roleRepo.save(userRole);
//
//        Address address=new Address();
//        address.setId(1);
//        address.setAddress_line1("1");
//        address.setAddress_line2("Empire Student Hall");
//        address.setStreet("Haywood Street");
//        address.setPostcode("ST4 2RB");
//        address.setTown("Stoke-on-Trent");
//
//
//
//        address.setCountry("United Kingdom");
//        address.setCounty("Staffordshire");
//
//        addressRepo.save(address);
//        User adminUser=new User();
//        adminUser.setUser_name("admin123");
//        adminUser.setFull_name("admin");
//        adminUser.setPhone("07438867659");
//        adminUser.setEmail("rifkhan94@yahoo.com");
//        adminUser.setPassword(getEncodedPassword("admin123"));
//        adminUser.setAddress(address);
//        Set<Role> adminRoles=new HashSet<>();
//        adminRoles.add(adminRole);
//        adminUser.setRole(adminRoles);
//        userRepo.save(adminUser);
//    }

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
