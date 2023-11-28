package com.educlaas.xyzcar.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.dto.PostDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.NotificationLog;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.UserRepository;
import com.educlaas.xyzcar.service.LikeEntityService;
import com.educlaas.xyzcar.service.NotificationLogService;
import com.educlaas.xyzcar.service.PostService;

@RestController
@RequestMapping(value = "/community")
@CrossOrigin(origins = "http://localhost:3000/")
public class NotificationController {

	//Get userid from Posttable and mapped to targetuser id in Notification table( to show who create the post)
	//Then go to LikeEntity table , find person who like the post based on post ID
	//then add creator and like id to NotificationLog table 

    

	@Autowired
    private LikeEntityService likeEntityService;

    @Autowired
    private NotificationLogService notificationLogService;
    
    @Autowired
    private UserRepository userRepository; // Autowire UserRepository

    @Autowired
    private PostRepository postRepository; // Autowire PostRepository
    
    @Autowired
    private CommunityRepository communityRepository;
    

    @PostMapping("/addLikesToNL/{userId}/{postId}/{targetUserId}/{notificationType}")
    public ResponseEntity<NotificationLog> addLikesToNL(@PathVariable Long userId,
                                                        @PathVariable Long postId,
                                                        @PathVariable Integer targetUserId,
                                                        @PathVariable int notificationType) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        NotificationLog addedNotificationLog = notificationLogService.addLikesToNL(existingUser, existingPost, targetUserId, notificationType);

        return new ResponseEntity<>(addedNotificationLog, HttpStatus.CREATED);
    }
    
    @PostMapping("/shareToNL/{userId}/{postId}/{targetUserId}/{notificationType}")
    public ResponseEntity<NotificationLog> shareToNL(@PathVariable Long userId,
                                                        @PathVariable Long postId,
                                                        @PathVariable Integer targetUserId,
                                                        @PathVariable int notificationType) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        NotificationLog addedNotificationLog = notificationLogService.shareToNL(existingUser, existingPost, targetUserId, notificationType);

        return new ResponseEntity<>(addedNotificationLog, HttpStatus.CREATED);
    }
    
    @PostMapping("/commentToNL/{userId}/{postId}/{targetUserId}/{notificationType}")
    public ResponseEntity<NotificationLog> commentToNL(@PathVariable Long userId,
                                                        @PathVariable Long postId,
                                                        @PathVariable Integer targetUserId,
                                                        @PathVariable int notificationType) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        NotificationLog addedNotificationLog = notificationLogService.commentToNL(existingUser, existingPost, targetUserId, notificationType);

        return new ResponseEntity<>(addedNotificationLog, HttpStatus.CREATED);
    }
    
    //Function 7
    @PostMapping("/memberToNL/{userId}/{communityId}/{targetUserId}/{notificationType}")
    public ResponseEntity<NotificationLog> memberToNL(@PathVariable Long userId,
                                                        @PathVariable Long communityId,
                                                        @PathVariable Integer targetUserId,
                                                        @PathVariable int notificationType) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Community existingCommunity = communityRepository.findById(communityId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        NotificationLog addedNotificationLog = notificationLogService.memberToNL(existingUser, existingCommunity, targetUserId, notificationType);

        return new ResponseEntity<>(addedNotificationLog, HttpStatus.CREATED);
    }
}
