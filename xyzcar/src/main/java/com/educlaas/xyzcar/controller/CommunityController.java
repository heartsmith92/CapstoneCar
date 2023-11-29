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
	
	
	//Function 5 Get All Post
    @GetMapping(value = "/get/community")
	public List<Community> getCommunity(){
		return CommunityService.findAllCommunity();
	}
    
    //Function 6 Filter Community by Status=1
    @GetMapping(value = "/get/commbystatus")
    public List<Community> getCommunitybyStatus() {
        
        Integer status = 1; // Set the status to filter disliked posts (assuming status 0 represents dislikes)

        return CommunityService.filterCommunityByStatus(status);
	
	   }
    
    //Function 7
    @PostMapping("/create/communitymember/{userId}/{communityId}")
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
    @PutMapping("/unjoin/{userId}/{communityId}")
    public ResponseEntity<String> updateUserMembership(
            @PathVariable Long userId,
            @PathVariable Long communityId,
            @RequestBody CreateCommunityDTO CreateCommunityDTO) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Community existingCommunity = communityRepository.findById(communityId)
                .orElseThrow(() -> new RuntimeException("Community not found"));

        // Logic to update membership status based on updateRequest (if necessary)
        // For instance, you might update membership status based on the updateRequest data

        // Assuming updateCommunityStatusToZero updates the membership status to zero
        communityRepository.updateCommunityStatusToZero(existingUser, existingCommunity.getCommunityID());

        return ResponseEntity.ok("User membership in community updated successfully");
    }
    
}
	
	
	

