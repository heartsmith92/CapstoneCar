package com.educlaas.xyzcar.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.dto.UpdatePostDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityRepository;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class PostService {

	 @Autowired
    private PostRepository postRepository;
	 
	 @Autowired
	 private UserRepository userRepository;                             
	 
	 @Autowired
	 private CommunityRepository communityRepository;

	 
	 //Function 16 //Function 24
	 public Post createPost(Long userId, Long communityId, CreatePostDTO createPostDTO) {
		    // Step A: Validate user existence
		    User existingUser = userRepository.findById(userId)
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    // Step B: Retrieve the existing community if available
		    Community existingCommunity = communityId != null ?
		            communityRepository.findById(communityId).orElse(null) : null;

		    // Step C: Create a new post with the provided data
		    Post postNew = new Post();

		    // Set attributes from the provided CreatePostDTO object
		    postNew.setCreatedDate(new Date());
		    postNew.setPostContent(createPostDTO.getPostContent());
		    postNew.setPostImgPath(createPostDTO.getPostImgPath());
		    postNew.setPostTitle(createPostDTO.getPostTitle());
		    postNew.setPostType(createPostDTO.getPostType());
		    postNew.setStatus(createPostDTO.getStatus());

		    // Set the user and community associations
		    postNew.setUser(existingUser);
		    postNew.setCommunity(existingCommunity);

		    // Save the new post in the database
		    Post createdPost = postRepository.save(postNew);

		    return createdPost;
		}


	//Function 13
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    


    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }



    // Function 25: Delete user post
    public void deleteUserPost(Long userId, Long postId) {
        // Validate user existence and post ownership
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Check if the post belongs to the specified user
        if (!existingPost.getUser().equals(existingUser)) {
            throw new RuntimeException("User does not own the specified post");
        }

        // Soft delete the post by updating its status to 0 (or another value representing deleted)
        existingPost.setStatus(0);
        postRepository.save(existingPost);
        
    }
    
    public Optional<Post> getTargetUserID(Long id) {
        return postRepository.findById(id);
    }

 // Function 24: Update user post
    public Post updateUserPost(Long userId, Long postId, UpdatePostDTO updatePostDTO) {
        // Validate user existence
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Retrieve the post to update
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Update post fields with the values from the DTO
        existingPost.setPostContent(updatePostDTO.getPostContent());
        existingPost.setPostImgPath(updatePostDTO.getPostImgPath());
        existingPost.setPostTitle(updatePostDTO.getPostTitle());
        existingPost.setPostType(updatePostDTO.getPostType());
        existingPost.setStatus(updatePostDTO.getStatus());

        // Save the updated post in the database
        Post updatedPost = postRepository.save(existingPost);

        return updatedPost;
    }



    
    //Function 14
    public List<Post> filterPostsByStatus(int status) {
    	return postRepository.findByStatus(status);
    	
    }
    
    // Function 22 
   
    public List<Post> findPostsByUserIdAndStatus(Long userId, Integer status) {
        return postRepository.findPostsByUserIdAndStatus(userId, status);
    }


    
    //Function 23 
    public void filterUserPostsByStatus(Long userId, int status) {
    	
    }
    
    
    
    
}