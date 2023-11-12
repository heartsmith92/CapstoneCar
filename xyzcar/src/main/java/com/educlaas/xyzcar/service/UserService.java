package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.config.JwtTokenProvider;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean isUsernameTaken(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User with this username already exists.");
        }

   
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setUserType(user.getUserType());
        newUser.setUserBio(user.getUserBio());
        newUser.setStatus(user.getStatus());
        newUser.setProfileImgPath(user.getProfileImgPath());
        newUser.setCreatedDate(new Date(System.currentTimeMillis())); // Set the current date
        // Set other user properties as needed

        userRepository.save(newUser);
        return newUser;
    }

    public String loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null) {
            throw new RuntimeException("User not found.");
        }

//        // Check if the provided password matches the stored password
//        if (!passwordEncoder.matches(existingUser.getPassword(), existingUser.getPassword())) {
//            throw new RuntimeException("Invalid password.");
//        }
        

        // Check if the provided password matches the stored password
        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid password.");
        }
        
                

        // Generate a JWT token for the user
        return tokenProvider.generateToken(existingUser.getUsername());
    }
   
    
    public List<User> getUser() {
		return userRepository.findAll();
	}
    
    public void postUser(User user){
    	userRepository.save(user);
	}
    
	public Optional<User> viewCar(Long userId) {
		return userRepository.findById(userId);
	}
}

