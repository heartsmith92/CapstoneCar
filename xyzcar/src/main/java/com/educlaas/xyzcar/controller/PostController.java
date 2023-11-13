package com.educlaas.xyzcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.service.PostService;


@RestController
@RequestMapping("/xyz/posts")
@CrossOrigin(origins = "http://localhost:3000")  
public class PostController {

	   @Autowired
	    private PostService postService;


	   //CreatePostUsingUserID
	   //It can also accept optional Community ID value 
	    @PostMapping("/createPost/{userId}")
	    public ResponseEntity<Post> createPost(
	            @PathVariable Long userId,
	            @RequestBody CreatePostDTO createPostDTO) {

	        // Call the service method to create a new post
	        Post createdPost = postService.createPost(userId, createPostDTO);

	        // Return the created post and a HTTP status code indicating success
	        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	    }



    // Add other methods for handling post-related endpoints
}