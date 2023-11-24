package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	   
	   
	   @PostMapping("/createPost/{userId}/{communityId}")
	   public ResponseEntity<Post> createPost(
	           @PathVariable Long userId,
	           @PathVariable(required = false) Long communityId,
	           @RequestBody CreatePostDTO createPostDTO) {

	       // Call the service method to create a new post
	       Post createdPost = postService.createPost(userId, communityId, createPostDTO);

	       // Return the created post and a HTTP status code indicating success
	       return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
	   }


	    
	    //Get All Post
	    @GetMapping(value = "/get/posts")
		public List<Post> getPost(){
			return postService.getAllPosts();
		}
	    
	    
	    //GetSpecificPost
	    @GetMapping(value = "/get/posts/{postId}")
		public Optional<Post> getPostById(@PathVariable Long postId){
			return postService.getPostById(postId);
		}
	    
	    
	    
	 // Function 14: Filter posts by status
	    @GetMapping("/filter/posts/{status}")
	    public List<Post> filterPostsByStatus(@PathVariable int status) {
	        return postService.filterPostsByStatus(status);
	    }


	    
	    


    // Add other methods for handling post-related endpoints
}