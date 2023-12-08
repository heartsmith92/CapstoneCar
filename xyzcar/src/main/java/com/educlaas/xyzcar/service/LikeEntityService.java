package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityRepository;
import com.educlaas.xyzcar.repository.LikeRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class LikeEntityService {

  @Autowired
  private LikeRepository likeRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private UserRepository userRepository;

  public void postdislike(LikeEntity likeEntity) {
    likeRepository.save(likeEntity);
  }

  public List < LikeEntity > getAllLikes() {
    return likeRepository.findAll();
  }

  public List < LikeEntity > getAllDisLikes() {
    return likeRepository.findAll();
  }

  public Optional < LikeEntity > getLikeById(Long id) {
    return likeRepository.findById(id);
  }

  //Function 17
  public LikeEntity createLike(LikeEntity likeEntity) {
    return likeRepository.save(likeEntity);
  }

  public LikeEntity updateLike(LikeEntity likeEntity) {
    return likeRepository.save(likeEntity);
  }

  public void deleteLike(Long id) {
    likeRepository.deleteById(id);
  }
  
  public LikeEntity addLikesToPost(Long userId, Long postId) {
	    // Retrieve the post based on the provided postId
	    Post post = postRepository.findById(postId)
	            .orElseThrow(() -> new RuntimeException("Post not found"));

	    // Retrieve the user based on the provided userId
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Try finding the existing like for the user and post
	    LikeEntity existingLike = likeRepository.findByUserAndPost(user, post);

	    if (existingLike != null) {
	        // If an existing like is found, update its status to 1 (liked)
	        existingLike.setStatus(1);

	        // Save the updated like in the database
	        return likeRepository.save(existingLike);
	    } else {
	        // If no existing like is found, create a new like
	        LikeEntity newLike = new LikeEntity();
	        newLike.setCreatedDate(new Date());
	        newLike.setStatus(1);
	        newLike.setUser(user);
	        newLike.setPost(post);

	        // Save the new like in the database
	        return likeRepository.save(newLike);
	    }
	}


  //Function 18
  public LikeEntity addDisLikesToPost(Long userId, Long postId) {
	// Retrieve the post based on the provided postId
	    Post post = postRepository.findById(postId)
	            .orElseThrow(() -> new RuntimeException("Post not found"));

	    // Retrieve the user based on the provided userId
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Try finding the existing like for the user and post
	    LikeEntity existingLike = likeRepository.findByUserAndPost(user, post);

    if (existingLike != null) {
      // If an existing like is found, change its status to 0 (disliked)
      existingLike.setStatus(0);
      existingLike.setCreatedDate(new Date()); // Update the date or leave as is

      // Save the updated like in the database
      return likeRepository.save(existingLike);
    } else {
      // If no existing like is found, create a new dislike
      LikeEntity dislike = new LikeEntity();
      dislike.setCreatedDate(new Date());
      dislike.setStatus(0);
      dislike.setUser(user); // Set the existing user associated with the post
      dislike.setPost(post);

      // Save the new dislike in the database
      return likeRepository.save(dislike);
    }
  }

  //Function 26 
  public List < Post > listUserLikedPosts(Long userId, Integer status) {
    return likeRepository.findAllLikedPostsByUserIdAndStatus(userId, status);
  }

  //Function 28 

  public void listUserDislikedPosts(Long userId) {}

  //Function 27 

  public List < Post > listUserDisLikedPosts(Long userId, Integer status) {
    return likeRepository.findAllDisLikedPostsByUserIdAndStatus(userId, status);

  }

  // Update like 
  public LikeEntity save(LikeEntity updateLike) {
    return likeRepository.save(updateLike);
  }

  public Optional < LikeEntity > findByUser_Id(Long id) {
    return likeRepository.findByUser_Id(id);
  }
  
  public Optional<LikeEntity> findByUserAndPost(Long userId, Long postId) {
	    // Retrieve the post based on the provided postId
	    Post post = postRepository.findById(postId)
	            .orElseThrow(() -> new RuntimeException("Post not found"));

	    // Retrieve the user based on the provided userId
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Try finding the existing like for the user and post
	    LikeEntity existingLike = likeRepository.findByUserAndPost(user, post);

	    // Wrap the existingLike in an Optional and return
	    return Optional.ofNullable(existingLike);
	}

  
  public Optional<LikeEntity> findLikeByUserAndPost(Long userId, Long postId) {
	// Retrieve the post based on the provided postId
	    Post post = postRepository.findById(postId)
	            .orElseThrow(() -> new RuntimeException("Post not found"));

	    // Retrieve the user based on the provided userId
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Try finding the existing like for the user and post
	    LikeEntity existingLike = likeRepository.findByUserAndPost(user, post);

	    // Wrap the existingLike in an Optional and return
	    return Optional.ofNullable(existingLike);
	}
}