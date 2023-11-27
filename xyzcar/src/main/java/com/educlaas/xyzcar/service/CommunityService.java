package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreateCommunityDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityRepository;
import com.educlaas.xyzcar.repository.UserRepository;
import com.educlaas.xyzcar.dto.CreatePostDTO;

@Service
public class CommunityService {
	
	@Autowired
	private  CommunityRepository communityRepository;
	
	 @Autowired
	 private UserRepository userRepository;                             
	 
	


	//
    public List<Community> listAllCommunities() {
        return communityRepository.findAll();
      
    }

    public Optional<Community> getCommunityById(Long id) {
        return communityRepository.findById(id);
    }

    
    
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }
    
    //Function 33
    public void createCommunity(Long userId , CreateCommunityDTO communityDTO) {
    	
    	
    }
    

    public Community updateCommunity(Community community) {
        return communityRepository.save(community);
    }

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

    //Function 7 Function 33
    public void filterCommunitiesByStatus(int status) {
    	
    }
    
    //Function 8 Function 34
    public void joinCommunity(Long userId, Long communityId) {
    	
    }
	
    
    //Function 30
    
    public void listUserCommunities(Long userId) {
    	
    }
    
    
    //Function 31
    public Community createCommunity(Long userId, CreateCommunityDTO createCommunityDTO, Long communityId) {

    	// Step A: Validate user existence
	    User existingUser = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // Step B: Retrieve the existing community if available
	    Community existingCommunity = communityId != null ?
	            communityRepository.findById(communityId).orElse(null) : null;

	    // Step C: Create a new community with the provided data
	    Community communityNew = new Community();

	    // Set attributes from the provided CreatePostDTO object
	    communityNew.setCreatedDate(new Date());
	    communityNew.setCommunityBio(createCommunityDTO.getCommunityBio());
	    communityNew.setCommunityLogoPath(createCommunityDTO.getCommunityLogoPath());
	    communityNew.setCommunityName(createCommunityDTO.getCommunityName());
	    communityNew.setStatus(createCommunityDTO.getStatus());

	    // Set the user and community associations
	    communityNew.setUser(existingUser);
	   

	    // Save the new post in the database
	    Community createcommunity = communityRepository.save(communityNew);

	    return createcommunity;
	}

    
    //Function 35
    public void unjoinCommunity(Long userId , Long communityId) {
    	
    	
    }
    
    

	
}
