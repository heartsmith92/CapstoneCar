package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CommentDTO;
import com.educlaas.xyzcar.entity.Comment;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommentRepository;
import com.educlaas.xyzcar.repository.PostRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    
    public void deleteCommentTest(Long id) {
        
    }
    //Function 18
    public Comment commentOnPost(Integer userId, Long postId,String commentText){
    	if (commentRepository == null) {
            // Log or print a message to indicate the null state
            System.out.println("CommentRepository is null");
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
        Comment comment = new Comment();
        comment.setCreatedDate(new Date());
        comment.setStatus(1);
        comment.setComment(commentText);
        comment.setUser(existingUser); // Set the existing user associated with the post
        comment.setPost(post);

        // Save the like in the database
//        LikeEntity createdLike = likeRepository.save(like);
        Comment createComment = postRepository.save(comment);

        return createComment; // Return the updated post
    	
    }
  
    
    //Function 28 
    public List<Post> listComment(Long userId, Integer status) {
        return commentRepository.listcomment(userId, status);
    }
    
    
}
