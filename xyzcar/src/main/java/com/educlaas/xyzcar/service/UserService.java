package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.config.JwtTokenProvider;
import com.educlaas.xyzcar.dto.UserDTO;
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
    
    //Check If Email is taken 
    public boolean isEmailTaken(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    //Find User By Email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //New Registration
    public User registerUser(UserDTO userDTO) {
        User existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser != null) {
            throw new RuntimeException("User with this email already exists.");
        }
   
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Hash the password
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setUserType(userDTO.getUserType());
        newUser.setUserBio(userDTO.getUserBio());
        newUser.setStatus(userDTO.getStatus());
        newUser.setProfileImgPath(userDTO.getProfileImgPath());
        newUser.setCreatedDate(new Date());
        // Set other user properties as needed
        
        User registerUser = userRepository.save(newUser);
        return registerUser;
    }
 

    //Login Registration 
    public String loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            throw new RuntimeException("User not found.");
        }

        // Check if the provided password matches the stored password
        if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Invalid password.");
        }

        // Generate a JWT token for the user
        return tokenProvider.generateToken(existingUser.getEmail());
    }
   
    //Get All Users
    public List<User> getUser() {
		return userRepository.findAll();
	}
    
    //Find By ID
	public Optional<User> getUserByID(Long userId) {
		return userRepository.findById(userId);
	}

	// Update User
	public User save(User updateUser) {
	    return userRepository.save(updateUser);
	}
	
    //Function 11
    public static void followFriend(Long userId, Long friendId) {
        UserService.followFriend(userId, friendId);
    }

	
	//Function 12
    public static void unfollowFriend(Long userId, Long friendId) {
        // Assuming you have a FollowService that handles unfollow logic
        UserService.unfollowFriend(userId, friendId);
    }

	public void postUser(User user) {
		// TODO Auto-generated method stub
		
	}
}

