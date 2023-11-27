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
import com.educlaas.xyzcar.dto.UpdatePostDTO;
import com.educlaas.xyzcar.dto.PostDTO;
import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.LikeEntity;

import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.Share;
import com.educlaas.xyzcar.service.CommentService;
import com.educlaas.xyzcar.service.LikeEntityService;
import com.educlaas.xyzcar.service.PostService;
import com.educlaas.xyzcar.service.ShareService;



@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "http://localhost:3000")  
public class PostController {

	   @Autowired
	    private PostService postService;
	   @Autowired
	   private LikeEntityService LikeEntityService;
	   
	   @Autowired
	   private ShareService ShareService;
	   
	   @Autowired
	   private CommentService CommentService;
	   
	   
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
	    
	    
	    
	 // Function 14: Filter posts by status
	    @GetMapping("/filter/posts/{status}")
	    public List<Post> filterPostsByStatus(@PathVariable int status) {
	        return postService.filterPostsByStatus(status);
	    }

	    
	 // Function 22: List user posts with optional status
	    @GetMapping("/get/posts/user/{userId}/{status}")
	    public List<Post> listUserPosts(
	            @PathVariable Long userId,
	            @PathVariable  Integer status) {
	        return postService.findPostsByUserIdAndStatus(userId, status);
	    }


	 // Function 24: Update user post
	    @PutMapping("/update/post/{userId}/{postId}")
	    public ResponseEntity<Post> updateUserPost(
	            @PathVariable Long userId,
	            @PathVariable Long postId,
	            @RequestBody UpdatePostDTO updatePostDTO) {

	        // Call the service method to update the post
	        Post updatedPost = postService.updateUserPost(userId, postId, updatePostDTO);

	        // Return the updated post and a HTTP status code indicating success
	        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
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
	   
	    //Function 26 Get All Likes where status =1 
	    @GetMapping(value = "/get/likes/{user}")
	    public List<Post> getlikedPosts() {
	        Long userId = 1L; // Replace this with the actual user ID you want to query for
	        Integer status = 1; // Set the status to filter disliked posts (assuming status 0 represents dislikes)

	        return LikeEntityService.listUserDisLikedPosts(userId, status);
		}
	    
	  //Function 27 Get All DisLikes where status=0
	    @GetMapping(value = "/get/dislikes/{user}")
	    public List<Post> getDislikedPosts() {
	        Long userId = 1L; // Replace this with the actual user ID you want to query for
	        Integer status = 0; // Set the status to filter disliked posts (assuming status 0 represents dislikes)

	        return LikeEntityService.listUserDisLikedPosts(userId, status);
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
	    
	    //Function 19 Share add to table 
	    @PostMapping("/sharePost/{userId}/{postId}")
	    public ResponseEntity<Share> share(
	            @PathVariable Integer userId,
	            @PathVariable Long postId) {

	        // Call the service method to create a new like
	        Share createShare = ShareService.sharePost(userId, postId);

	        // Return the updated post and a HTTP status code indicating success
	        return new ResponseEntity<>(createShare, HttpStatus.CREATED);
	    }
	 
	  //Function 18 Share add to table 
	    @PostMapping("/commentOnPost/{userId}/{postId}")
	    public ResponseEntity<Comment> comment(
	            @PathVariable Integer userId,
	            @PathVariable Long postId) {

	        // Call the service method to create a new like
	        Comment createComment = CommentService.commentOnPost(userId, postId);

	        // Return the updated post and a HTTP status code indicating success
	        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
	    }
	    
	    //Function 28 list all comment
	    @GetMapping(value = "/get/comment/{user}")
	    public List<Post> getComment() {
	        Long userId = 1L; // Replace this with the actual user ID you want to query for
	        Integer status = 1; // Set the status to filter disliked posts (assuming status 0 represents dislikes)

	        return CommentService.listComment(userId, status);
		}
}


    // Add other methods for handling post-related endpoints
