package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.Share;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.PostRepository;
import com.educlaas.xyzcar.repository.ShareRepository;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Share> getAllShares() {
        return shareRepository.findAll();
    }

    public Optional<Share> getShareById(Long id) {
        return shareRepository.findById(id);
    }

    public Share createShare(Share share) {
        return shareRepository.save(share);
    }

    public Share updateShare(Share share) {
        return shareRepository.save(share);
    }

    public void deleteShare(Long id) {
        shareRepository.deleteById(id);
    }
    
    //function 20 
    
    public Share sharePost(Integer userId , Long postId) {
    	if (shareRepository == null) {
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
        Share share = new Share();
        share.setCreatedDate(new Date());
        share.setStatus(1);
        share.setUser(existingUser); // Set the existing user associated with the post
        share.setPost(post);

        // Save the like in the database
//        LikeEntity createdLike = likeRepository.save(like);
        Share createShare = postRepository.save(share);

        return createShare; // Return the updated post
    }
}
