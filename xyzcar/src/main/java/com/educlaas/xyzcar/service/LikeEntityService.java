package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.dto.PostDTO;
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



    
    
    public  void postdislike(LikeEntity likeEntity) {
    	likeRepository.save(likeEntity);
    }

    public List<LikeEntity> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<LikeEntity> getLikeById(Long id) {
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
    public LikeEntity addLikesToPost(Integer userId, Long postId) {
    	
    	if (likeRepository == null) {
            // Log or print a message to indicate the null state
            System.out.println("LikeRepository is null");
            // You can use a logger instead of System.out.println
        }
        // Step A: Retrieve the post based on postId
    	Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Retrieve the existing user associated with the provided postId
        User existingUser = post.getUser(); // Assuming the post has a user associated with it

        // Ensure the user associated with the post exists
        if (existingUser == null) {
            throw new RuntimeException("User associated with the post not found");
        }

        // Step B: Create LikeEntity objects for the given PostDTO
        LikeEntity like = new LikeEntity();
        like.setCreatedDate(new Date());
        like.setStatus(1);
        like.setUser(existingUser); // Set the existing user associated with the post
        like.setPost(post);

        // Save the like in the database
//        LikeEntity createdLike = likeRepository.save(like);
        LikeEntity createdLike = postRepository.save(like);

        return createdLike; // Return the updated post
    }

    
    
    //Function 18
    public LikeEntity addDisLikesToPost(Integer userId, Long postId) {
        if (likeRepository == null) {
            // Log or print a message to indicate the null state
            System.out.println("LikeRepository is null");
            // You can use a logger instead of System.out.println
        }

        // Step A: Retrieve the post based on postId
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Retrieve the existing user associated with the provided postId
        User existingUser = post.getUser(); // Assuming the post has a user associated with it

        // Ensure the user associated with the post exists
        if (existingUser == null) {
            throw new RuntimeException("User associated with the post not found");
        }

        // Step B: Check if there is an existing like for this user and post
        LikeEntity existingLike = likeRepository.findByUserAndPost(existingUser, post);

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
            dislike.setUser(existingUser); // Set the existing user associated with the post
            dislike.setPost(post);

            // Save the new dislike in the database
            return likeRepository.save(dislike);
        }
    }

    
    //Function 27 
    public void listUserLikedPosts(Long userId) {
    	
    	
    }
    
    
    //Function 28 
    
    public void listUserDislikedPosts(Long userId) {}

	
    
}


