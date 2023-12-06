package com.educlaas.xyzcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.xyzcar.dto.CreateCommunityDTO;
import com.educlaas.xyzcar.dto.CreatePostDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.CommunityMember;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityRepository;
import com.educlaas.xyzcar.repository.UserRepository;
import com.educlaas.xyzcar.service.CommunityMemberService;
import com.educlaas.xyzcar.service.CommunityService;

@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "http://localhost:3000/")
public class CommunityController {
	
	   @Autowired
			private CommunityService CommunityService;
	   
	   @Autowired
	    private CommunityMemberService communityMemberService;
	   
	   @Autowired
	    private CommunityRepository communityRepository;
	   
	   @Autowired
	   private UserRepository userRepository;
	   
	  
	        
	        
	//function 31
	@PostMapping("/create/{userId}/community")
	   public ResponseEntity<Community> createCommunity(
	           @PathVariable Long userId,
	           @PathVariable(required = false) Long communityId,
	           @RequestBody CreateCommunityDTO createCommunityDTO) {

	       // Call the service method to create a new post
	       Community createCommunity = CommunityService.createCommunity(userId, createCommunityDTO, communityId);

	       // Return the created post and a HTTP status code indicating success
	       return new ResponseEntity<>(createCommunity, HttpStatus.CREATED);
	   }
	
	
	//Function 5 Get All Post
    @GetMapping(value = "/get/communities")
	public List<Community> getCommunity(){
		return CommunityService.findAllCommunity();
	}
    
    //Function 6 Filter Community by Status=1
    @GetMapping(value = "/get/communities/active")
    public List<Community> getCommunitybyStatus() {
        
        Integer status = 1; // Set the status to filter disliked posts (assuming status 0 represents dislikes)

        return CommunityService.filterCommunityByStatus(status);
	
	   }
    
    //Function 7
    @PostMapping("/member/join/{userId}/{communityId}")
	   public ResponseEntity<CommunityMember> createCommunityMember(
	           @PathVariable Integer userId,
	           @PathVariable(required = false) Long communityId,
	           @RequestBody CreateCommunityDTO createCommunityDTO) {

	       // Call the service method to create a new post
    	CommunityMember createMember = communityMemberService.createCommunityMember(userId, communityId);


	       // Return the created post and a HTTP status code indicating success
	       return new ResponseEntity<>(createMember, HttpStatus.CREATED);
	   }
    //Function 34
    @PostMapping("/member/unjoin/{userId}/{communityId}")
    public ResponseEntity<CommunityMember> unjoinCommunityMember(
           @PathVariable Integer userId,
           @PathVariable(required = false) Long communityId,
           @RequestBody CreateCommunityDTO createCommunityDTO) {


        // Call the service method to unjoin the user from the community
        CommunityMember unjoinMember = communityMemberService.unjoinCommunityMember(userId, communityId);

        // Return the unjoined member and an HTTP status code indicating success
        return new ResponseEntity<>(unjoinMember, HttpStatus.OK);
    }
    
    
    //Function 30 Filter User based on Community 
    @GetMapping(value = "/get/userbycommunity/{user}")
    public List<Community> getUserByCommunity(@PathVariable Long user) {
        String status = "1"; // Set the status to filter communities (e.g., "active", "inactive")
        return CommunityService.listUserCommunitiesByStatus(user, status);
	
	   }
    
    // get all the community member details
    @GetMapping(value = "/get/community/member")
    public List<CommunityMember> getAllCommunityMembers(){
		return communityMemberService.getAllCommunityMembers();
	}
}
	
	
	

