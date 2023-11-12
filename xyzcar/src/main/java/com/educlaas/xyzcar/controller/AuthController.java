package com.educlaas.xyzcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.config.JwtTokenProvider;
import com.educlaas.xyzcar.dto.UserDTO;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.AuthResponse;
import com.educlaas.xyzcar.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
    	try {
            // Check if the username is already in use
            if (userService.isUsernameTaken(userDTO.getUsername())) {
                return ResponseEntity.badRequest().body("Username is already taken.");
            }

            // Create a new user entity and save it to the database
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword()); // Hash the password
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setUserType(userDTO.getUserType());
            user.setUserBio(userDTO.getUserBio());
            user.setStatus(userDTO.getStatus());
            user.setProfileImgPath(userDTO.getProfileImage());

            // You may set other user properties here

            User registeredUser = userService.registerUser(user);

            // Return a success message or status code
            return ResponseEntity.ok("User registered successfully: " + registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
    	try {
            // Find the user by username
            User user = userService.findByUsername(userDTO.getUsername());

            if (user == null) {
                return ResponseEntity.badRequest().body("User not found.");
            }

            // Check if the provided password matches the stored password (you should use a password encoder)
            if (!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password.");
            }

            // Generate a JWT token for the user
            String token = tokenProvider.generateToken(user.getUsername());

            // Create a custom response object to include user details and token
            AuthResponse authResponse = new AuthResponse(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), token, user.getProfileImgPath());

            // Return the custom response object as JSON
            return ResponseEntity.ok(authResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User login failed.");
        }
    }
}

