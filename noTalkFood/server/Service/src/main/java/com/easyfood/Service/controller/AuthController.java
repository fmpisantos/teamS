package com.easyfood.Service.controller;

import com.easyfood.Service.DTO.UserDTO;
import com.easyfood.Service.DAO.Security.JwtRequest;
import com.easyfood.Service.DAO.Security.JwtResponse;

import com.easyfood.Service.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<JwtResponse> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(authService.register(user));
    }

}