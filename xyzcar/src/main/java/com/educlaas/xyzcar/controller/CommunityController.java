package com.educlaas.xyzcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.CreateCommunityDTO;
import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.service.CommunityService;

@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "http://localhost:3000/")
public class CommunityController {
	
	   @Autowired
			private CommunityService CommunityService;
	
	@PostMapping("/create/community/{userId}")
	   public ResponseEntity<Community> createCommunity(
	           @PathVariable Long userId,
	           @PathVariable(required = false) Long communityId,
	           @RequestBody CreateCommunityDTO createCommunityDTO) {

	       // Call the service method to create a new post
	       Community createCommunity = CommunityService.createCommunity(userId, createCommunityDTO, communityId);

	       // Return the created post and a HTTP status code indicating success
	       return new ResponseEntity<>(createCommunity, HttpStatus.CREATED);
	   }
	
	   }
	
	
	

