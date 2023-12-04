package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.UserDTO;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.service.FollowService;
import com.educlaas.xyzcar.service.UserService;

@RestController
@RequestMapping(value = "/community")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	private UserService userService;
	

    @Autowired
    private FollowService followService;
	
	@PostMapping(value = "/users")
	public void postUser(@RequestBody User user) {
		userService.postUser(user);
	}

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

    // Function 8: List Followed Friends
    @GetMapping(value = "/users/{userId}/followed-friends")
    public List<User> listFollowedFriends(@PathVariable Long userId) {
        return followService.listFollowedFriends(userId);
    }

    // Function 9: Filter Friends by Status
    @GetMapping(value = "/users/{userId}/friends/{status}")
    public List<User> filterFriendsByStatus(@PathVariable Long userId, @PathVariable int status) {
        return followService.filterFriendsByStatus(userId, status);
    }

    // Function 10: Search Friends
    @GetMapping(value = "/users/search")
    public List<User> searchFriends(@RequestParam String query) {
        return followService.searchFriends(query);
    }

    // Function 11: Follow Friend
    @PostMapping(value = "/users/{userId}/follow/{friendId}")
    public void followFriend(@PathVariable Long userId, @PathVariable Long friendId) {
        UserService.followFriend(userId, friendId);
    }

    // Function 12: Unfollow Friend
    @DeleteMapping(value = "/users/{userId}/unfollow/{friendId}")
    public void unfollowFriend(@PathVariable Long userId, @PathVariable Long friendId) {
        UserService.unfollowFriend(userId, friendId);
    }

}
