package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.Follow;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.FollowRepository;
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public List<Follow> getAllFollows() {
        return followRepository.findAll();
    }

    public Optional<Follow> getFollowById(Long id) {
        return followRepository.findById(id);
    }

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public Follow updateFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }
    
    //Function 8 
    public List<User> listFollowedFriends(Long userId) {
        List<Follow> follows = followRepository.findByUserId(userId);
        
        List<User> followedFriends = follows.stream()
                .map(Follow::getUser)
                .collect(Collectors.toList());
        
        return followedFriends;
    }

    
    //Function 9 
    public List<User> filterFriendsByStatus(Long userId, int status) {
        List<Follow> follows = followRepository.findByUserIdAndStatus(userId, status);
        
        List<User> friendsWithStatus = follows.stream()
                .map(Follow::getUser)
                .collect(Collectors.toList());
        
        return friendsWithStatus;
    }
    
    
    //Function 10
    public List<User> searchFriends(String query) {
    	List<User> foundFriends = UserRepository.findByUsernameContainingIgnoreCase(query);
        
        return foundFriends;
    }

    
    //Function 11
    public static void followFriend(Long userId, Long friendId) {
        FollowService.followFriend(userId, friendId);
    }

	
	//Function 12
    public static void unfollowFriend(Long userId, Long friendId) {
        // Assuming you have a FollowService that handles unfollow logic
        FollowService.unfollowFriend(userId, friendId);
    }

	
	
}
