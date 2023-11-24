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
import com.educlaas.xyzcar.dto.PostDTO;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.service.LikeEntityService;
import com.educlaas.xyzcar.service.PostService;



@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "http://localhost:3000")  
public class PostController {

	   @Autowired
	    private PostService postService;
	   @Autowired
	   private LikeEntityService LikeEntityService;
	   
	   
	   @PostMapping("/create/post/{userId}/{communityId}")
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
	    @GetMapping(value = "/get/post/{postId}")
		public Optional<Post> getPostById(@PathVariable Long postId){
			return postService.getPostById(postId);
		}
	    
	    @PostMapping("/addLikesToPost/{userId}/{postId}")
	    public ResponseEntity<LikeEntity> addLikesToPost(
	            @PathVariable Integer userId,
	            @PathVariable Long postId) {

	        // Call the service method to create a new like
	        LikeEntity createdLike = LikeEntityService.addLikesToPost(userId, postId);

	        // Return the updated post and a HTTP status code indicating success
	        return new ResponseEntity<>(createdLike, HttpStatus.CREATED);
	    }
	
	    //Get All Likes
	    @GetMapping(value = "/get/likes")
		public List<LikeEntity> getLike(){
			return LikeEntityService.getAllLikes();
		}
	    
	    //GetSpecificLikes
	    @GetMapping(value = "/get/posts/{likeId}")
		public Optional<LikeEntity> getLikeById(@PathVariable Long likeId){
			return LikeEntityService.getLikeById(likeId);
		}
	    
	    //Function 17 
	    @PostMapping("/addDisLikesToPost/{userId}/{postId}")
	    public ResponseEntity<LikeEntity> addDisLikesToPost(
	            @PathVariable Integer userId,
	            @PathVariable Long postId) {

	        // Call the service method to create a new like
	        LikeEntity createdDisLike = LikeEntityService.addDisLikesToPost(userId, postId);

	        // Return the updated post and a HTTP status code indicating success
	        return new ResponseEntity<>(createdDisLike, HttpStatus.CREATED);
	    }
	 
}


    // Add other methods for handling post-related endpoints
