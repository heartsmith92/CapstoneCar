package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.UserDTO;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.service.UserService;

@RestController
@RequestMapping(value = "/community")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 1. Create user 
	@PostMapping(value = "/create/users")
	public void createUser(@RequestBody UserDTO userDTO) {
		userService.registerUser(userDTO);
	}
	
	// 2. Get user details
	@GetMapping(value = "/get/users")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	// 3. Get user by Id
	@GetMapping(value = "/get/user/{userId}")
	public Optional<User> getUserByID(@PathVariable Long userId){
		return userService.getUserByID(userId);
	}
	
	// 4. Update user details by userId
	@PutMapping(value = "/put/user/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		Optional<User> existingUser = getUserByID(userId);
		
		User updateUser = existingUser.get();
		
		updateUser.setUsername(userDTO.getUsername());
		updateUser.setFirstName(userDTO.getFirstName());
		updateUser.setLastName(userDTO.getLastName());
		updateUser.setUserBio(userDTO.getUserBio());
		updateUser.setProfileImgPath(userDTO.getProfileImgPath());
		
		return userService.save(updateUser);
	}
	
	// 5. Update user status by userId
	@PutMapping(value = "/put/user/status/{userId}")
	public User updateUserStatus(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		Optional<User> existingUser = getUserByID(userId);
	    
	    if (existingUser.isPresent()) {
	        User updateUser = existingUser.get();
	        
	        updateUser.setStatus(userDTO.getStatus());
	        return userService.save(updateUser);
	    } else {
	        throw new RuntimeException("User not found with ID: " + userId);
	    }
	}

	
}
