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
import com.educlaas.xyzcar.repository.UserRepository;

@Service
public class ShareService {

    @Autowired
    private ShareRepository shareRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userrepository;
    

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
    
    //function 19 Share post 
    
    public Share sharePost(Long userId, Long postId) {
        if (shareRepository == null) {
            System.out.println("ShareRepository is null");
        }
        
        // Step A: Retrieve the post based on postId
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        // Retrieve the user sharing the post (assuming you have a UserRepository)
        User sharingUser = userrepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Step B: Create Share object for the given post and user
        Share share = new Share();
        share.setCreatedDate(new Date());
        share.setStatus(1);
        share.setUser(sharingUser); // Set the user who is sharing the post
        share.setPost(post);

        // Save the share in the database
        Share createdShare = shareRepository.save(share);

        return createdShare; // Return the updated post
    }
}
