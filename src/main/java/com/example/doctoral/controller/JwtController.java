package com.example.doctoral.controller;

import com.example.doctoral.entity.JwtRequest;
import com.example.doctoral.entity.JwtResponse;
import com.example.doctoral.user.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return jwtService.createJwtToken(jwtRequest);
    }
}
