package com.hospital.service;

import com.hospital.entity.Users;
import com.hospital.repository.UsersRepository;
import com.hospital.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements org.springframework.security.core.userdetails.UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // To generate JWT token
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return users;
    }

    public Users getUsersByIdentityNo(long identityNo){
        return usersRepository.findByIdentityNo(identityNo)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with identityNo: " + identityNo));
    }

    public Users register(String name, String surname, String username, String email, String password)  {
        // Check if the username or email is already taken
        Optional<Users> existingUserByUsername = usersRepository.findByUsername(username);
        if (existingUserByUsername.isPresent()) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        Optional<Users> existingUserByEmail = usersRepository.findByEmail(email);
        if (existingUserByEmail.isPresent()) {
            throw new IllegalArgumentException("Email is already taken.");
        }

        // Create a new user entity and set the user details
        Users newUser = new Users();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setUsername(username);
        newUser.setEmail(email);

        // Encrypt the password before saving (only if passwords are required)
        newUser.setPassword(passwordEncoder.encode(password));

        // Save the new user to the database
        return usersRepository.save(newUser);
    }



    public Users getUserByUsername(String username){
        return usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    public Optional<Users> getUserById(Long id){
        return usersRepository.findById(id);
    }

    public Users saveUser(Users users){
        return usersRepository.save(users);
    }

    public void deleteUsers(Long id){
        usersRepository.deleteById(id);
    }


}
