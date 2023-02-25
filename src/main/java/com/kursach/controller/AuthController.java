package com.kursach.controller;

import com.kursach.WebSecurityConfig;
import com.kursach.controller.resource.LoginResult;
import com.kursach.entity.Role;
import com.kursach.entity.User;
import com.kursach.repository.UserRepository;
import com.kursach.security.JwtHelper;
import com.kursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

/**
 * The auth controller to handle login requests
 *
 * @author imesha
 */
@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
public class AuthController {

    @Autowired
    UserService userService;

    private final JwtHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;


    private final UserRepository userRepository;

    public AuthController(JwtHelper jwtHelper, UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.jwtHelper = jwtHelper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "login")
    public LoginResult login(
            @RequestParam String username,
            @RequestParam String password) {

        User user;
        try {
            user = userRepository.findByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        if (passwordEncoder.matches(password, user.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("username", username);

            String roles = String.join(" ", user.getRoles().stream().map(Role::getName).toArray(String[]::new));
            claims.put(WebSecurityConfig.AUTHORITIES_CLAIM_NAME, roles);

            String jwt = jwtHelper.createJwtForClaims(username, claims);
            return new LoginResult(jwt);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
    }

    @PostMapping(path="signup")
    public boolean Registration(User user) {
        return userService.saveUser(user);
    }
}
