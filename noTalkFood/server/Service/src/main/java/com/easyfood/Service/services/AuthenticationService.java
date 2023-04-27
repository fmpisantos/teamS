package com.easyfood.Service.services;

import com.easyfood.Service.DAO.Security.JwtRequest;
import com.easyfood.Service.DAO.Security.JwtResponse;
import com.easyfood.Service.DAO.Security.User.Role;
import com.easyfood.Service.DAO.Security.User.User;
import com.easyfood.Service.DTO.UserDTO;
import com.easyfood.Service.repository.IUserRepository;
import com.easyfood.Service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public JwtResponse register(UserDTO authenticationRequest) {
        var user = User.builder()
                .firstName(authenticationRequest.getFirstName())
                .lastName(authenticationRequest.getLastName())
                .email(authenticationRequest.getEmail())
                .password(passwordEncoder.encode(authenticationRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return JwtResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }

    public JwtResponse authenticate(JwtRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();//TODO: ADD EXECPTION
        var jwtToken = jwtService.generateToken(user);

        return JwtResponse.builder()
                .jwtToken(jwtToken)
                .build();
    }
}
