package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.dto.UpdatePostDTO;
import com.educlaas.xyzcar.dto.UserDTO;
import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.CommunityMember;
import com.educlaas.xyzcar.entity.LikeEntity;

import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.Share;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.LikeRepository;
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

  @PostMapping("/post/create/{userId}/{communityId}")
  public ResponseEntity < Post > createPost(
    @PathVariable Long userId,
    @PathVariable(required = false) Long communityId,
    @RequestBody CreatePostDTO createPostDTO) {

    // Call the service method to create a new post
    Post createdPost = postService.createPost(userId, communityId, createPostDTO);

    // Return the created post and a HTTP status code indicating success
    return new ResponseEntity < > (createdPost, HttpStatus.CREATED);
  }

  //Get All Post
  @GetMapping(value = "/post/get")
  public List < Post > getPost() {
    return postService.getAllPosts();
  }

  //GetSpecificPost
  @GetMapping(value = "/post/get/{postId}")
  public Optional < Post > getPostById(@PathVariable Long postId) {
    return postService.getPostById(postId);
  }

  // Function 25: Delete user post
  @DeleteMapping("/post/delete/{userId}/{postId}")
  public ResponseEntity < Void > deleteUserPost(
    @PathVariable Long userId,
    @PathVariable Long postId) {

    // Call the service method to delete the post
    postService.deleteUserPost(userId, postId);

    // Return a HTTP status code indicating success
    return new ResponseEntity < > (HttpStatus.NO_CONTENT);
  }
  // Function 14: Filter posts by status
  @GetMapping("/post/filter/{status}")
  public List < Post > filterPostsByStatus(@PathVariable int status) {
    return postService.filterPostsByStatus(status);
  }

  // Function 22: List user posts with optional status
  @GetMapping("/post/get/user/{userId}/{status}")
  public List < Post > listUserPosts(
    @PathVariable Long userId,
    @PathVariable Integer status) {
    return postService.findPostsByUserIdAndStatus(userId, status);
  }

  // Function 24: Update user post
  @PutMapping("/post/update/{userId}/{postId}")
  public ResponseEntity < Post > updateUserPost(
    @PathVariable Long userId,
    @PathVariable Long postId,
    @RequestBody UpdatePostDTO updatePostDTO) {

    // Call the service method to update the post
    Post updatedPost = postService.updateUserPost(userId, postId, updatePostDTO);

    // Return the updated post and a HTTP status code indicating success
    return new ResponseEntity < > (updatedPost, HttpStatus.OK);
  }

  //Function 16

  //Add like to post 

  @PostMapping("/post/add-like/{userId}/{postId}")
  public ResponseEntity < LikeEntity > addLikesToPost(
    @PathVariable Long userId,
    @PathVariable Long postId) {

    // Call the service method to create a new like
    LikeEntity createdLike = LikeEntityService.addLikesToPost(userId, postId);

    // Return the updated post and a HTTP status code indicating success
    return new ResponseEntity < > (createdLike, HttpStatus.CREATED);
  }

  //Function 26 Get All Likes where status =1 
  @GetMapping(value = "/post/likes/get")
  public List < LikeEntity > getlikedPosts() {
    return LikeEntityService.getAllLikes();
  }

  //Function 27 Get All DisLikes where status=0
  @GetMapping(value = "/post/share/get")
  public List < Share > getSharePosts() {
    return ShareService.getAllShares();
  }

  //GetSpecificLikes
  @GetMapping(value = "/post/get/posts/{likeId}")
  public Optional < LikeEntity > getLikeById(@PathVariable Long likeId) {
    return LikeEntityService.getLikeById(likeId);
  }

  //Function 17 
  @PostMapping("/post/add-dislike/{userId}/{postId}")
  public ResponseEntity < LikeEntity > addDisLikesToPost(
    @PathVariable Long userId,
    @PathVariable Long postId) {

    // Call the service method to create a new like
    LikeEntity createdDisLike = LikeEntityService.addDisLikesToPost(userId, postId);

    // Return the updated post and a HTTP status code indicating success
    return new ResponseEntity < > (createdDisLike, HttpStatus.CREATED);
  }

  //Function 19 Share add to table 
  @PostMapping("/post/share/{userId}/{postId}")
  public ResponseEntity < Share > share(
    @PathVariable Long userId,
    @PathVariable Long postId) {

    // Call the service method to create a new like
    Share createShare = ShareService.sharePost(userId, postId);

    // Return the updated post and a HTTP status code indicating success
    return new ResponseEntity < > (createShare, HttpStatus.CREATED);
  }
  //Function 18 Share add to table 
  @PostMapping("post/comment/{userId}/{postId}/{commentText}")
  public ResponseEntity < Comment > comment(
    @PathVariable Long userId,
    @PathVariable Long postId,
    @PathVariable String commentText) {

    // Call the service method to create a new like
    Comment createComment = CommentService.commentOnPost(userId, postId, commentText);

    // Return the updated post and a HTTP status code indicating success
    return new ResponseEntity < > (createComment, HttpStatus.CREATED);
  }

  //Function 28 list all comment
  @GetMapping(value = "/comment/get")
  public List < Comment > getComment() {
    return CommentService.getAllComments();
  }

  // get like by userid
  @GetMapping(value = "/post/like/get/{userId}/{postId}")
  public Optional < LikeEntity > getLikeByUserId(@PathVariable Long userId, @PathVariable Long postId) {
    return LikeEntityService.findLikeByUserAndPost(userId, postId);
  }

  // update like status by status
  @PostMapping(value = "/post/like/status/{userId}/{postId}/{status}")
  public LikeEntity updateLikeStatus(@PathVariable Long userId, @PathVariable Long postId, @PathVariable int status) {
    Optional < LikeEntity > existingLike = LikeEntityService.findLikeByUserAndPost(userId, postId);

    if (existingLike.isPresent()) {
      LikeEntity like = existingLike.get();

      if (like.getPost().getPostID().equals(postId)) {
        like.setStatus(status);
        return LikeEntityService.save(like);
      } else {
        throw new RuntimeException("User did not like the post with ID: " + postId);
      }
    } else {
      throw new RuntimeException("Like not found for user with ID: " + userId);
    }
  }
}