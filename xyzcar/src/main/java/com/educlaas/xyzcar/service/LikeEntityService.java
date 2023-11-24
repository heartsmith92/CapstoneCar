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
    private static LikeRepository likeRepository;
    @Autowired
    private static PostRepository postRepository;


    
    
    public static void postdislike(LikeEntity likeEntity) {
    	likeRepository.save(likeEntity);
    }

    public List<LikeEntity> getAllLikes() {
        return likeRepository.findAll();
    }

    public Optional<LikeEntity> getLikeById(Long id) {
        return likeRepository.findById(id);
    }

    //Function 17
    public static LikeEntity createLike(LikeEntity likeEntity) {
        return likeRepository.save(likeEntity);
    }

    public LikeEntity updateLike(LikeEntity likeEntity) {
        return likeRepository.save(likeEntity);
    }

    public void deleteLike(Long id) {
    	likeRepository.deleteById(id);
    }
    public LikeEntity addLikesToPost(Integer user, Integer post, PostDTO postDTO) {
        // Step A: Retrieve the post based on postId
        postLike postLike = postRepository.findById(post)
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
        like.setStatus(postDTO.getStatus());
        like.setUser(existingUser); // Set the existing user associated with the post
        like.setPost(postLike);

        // Save the like in the database
        LikeEntity createdLike = LikeRepository.save(like);

        return createdLike; // Return the updated post
    }

    
    
    //Function 18
    public void dislikePost(Long userId, Long postId) {
    	
    }
    
    //Function 27 
    public void listUserLikedPosts(Long userId) {
    	
    	
    }
    
    
    //Function 28 
    
    public void listUserDislikedPosts(Long userId) {}

	
    
}


