package com.educlaas.xyzcar.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreatePostDTO;
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


 
	 
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
	    }

    // Add other methods as needed for post-related business logic
}