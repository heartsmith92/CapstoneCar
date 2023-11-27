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

import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.service.FollowService;
import com.educlaas.xyzcar.service.UserService;

@RestController
@RequestMapping(value = "/xyz")
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
	
	//1. View User API
	@GetMapping(value = "/users")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	@GetMapping(value = "/users/{userId}")
	public Optional<User> viewUser(@PathVariable Long userId){
		return userService.viewCar(userId);
	}
	
	//2. Post User API
	@PutMapping(value = "/users/{userId}")
	public User updateCar(@PathVariable Long userId, @RequestBody User user) {
		
		Optional<User> existingUser = viewUser(userId);
		
		User updateUser = existingUser.get();
		
		updateUser.setUsername(user.getUsername());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setProfileImgPath(user.getProfileImgPath());
		
		postUser(updateUser);
		
		return updateUser;
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
        FollowService.followFriend(userId, friendId);
    }

    // Function 12: Unfollow Friend
    @DeleteMapping(value = "/users/{userId}/unfollow/{friendId}")
    public void unfollowFriend(@PathVariable Long userId, @PathVariable Long friendId) {
        followService.unfollowFriend(userId, friendId);
    }

}
