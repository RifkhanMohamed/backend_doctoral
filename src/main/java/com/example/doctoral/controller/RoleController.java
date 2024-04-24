package com.example.doctoral.controller;

import com.example.doctoral.entity.Role;
import com.example.doctoral.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/role")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class RoleController {

    private final RoleService roleService;

    @PostMapping(path = "/create")
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }
}
