package com.educlaas.xyzcar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.service.PostService;



@RestController
@RequestMapping(value = "/xyz")
@CrossOrigin(origins = "http://localhost:3000/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping(value = "/get/posts")
	public List<Post> getPost(){
		return postService.getAllPosts();
	}
	
	@GetMapping(value = "/get/posts/{postId}")
	public Optional<Post> getPostById(@PathVariable Long postId){
		return postService.getPostById(postId);
	}
	
	@PostMapping(value = "/create/post")
	public void createPost(@RequestBody Post post) {
		postService.createPost(post);
	}
	
	@PutMapping(value = "/put/post/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody Post post) {
		
		Optional<Post> existingPost = getPostById(postId);
		Post updatePost = existingPost.get();
		updatePost.setPostTitle(post.getPostTitle());
		updatePost.setPostContent(post.getPostContent());
		updatePost.setPostImgPath(post.getPostImgPath());
		createPost(updatePost);
		
		return updatePost;
	}
	
	@PutMapping(value = "/put/post/status/{postId}")
	public Post updatePostStatus(@PathVariable Long postId, @RequestBody Post post) {
		
		Optional<Post> existingPost = getPostById(postId);
		Post updatePost = existingPost.get();
		updatePost.setStatus(post.getStatus());
		createPost(updatePost);
		
		return updatePost;
	}
}
