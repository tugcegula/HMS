package com.hospital.controller;

import com.hospital.entity.Users;
import com.hospital.security.JwtTokenProvider;
import com.hospital.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/","users"})
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UsersController(UsersService usersService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.usersService = usersService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable("username") String username) {
        Optional<Users> users = Optional.ofNullable(usersService.getUserByUsername(username));
        return  users.map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.status(HttpStatus.NOT_FOUND)
                                              .body(null));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
        Optional<Users> users = usersService.getUserById(id);
        return users.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                                                   .body(null));
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users) {
        try {
            Users newUser = usersService.register(
                    users.getName(),
                    users.getSurname(),
                    users.getUsername(),
                    users.getEmail(),
                    users.getPassword()
            );
            return ResponseEntity.ok("User registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser( String username,  String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // Kimlik doğrulama başarılıysa, JWT token'ı oluştur (isteğe bağlı)
            String jwt = jwtTokenProvider.generateToken(authentication);

            // JWT token'ı döndür
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
