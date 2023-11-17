package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.dto.CreateCommunityDTO;
import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.repository.CommunityRepository;

@Service
public class CommunityService {
	
	@Autowired
	private  CommunityRepository communityRepository;


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
    public void filterUserCommunitiesByStatus(Long userId, int status) {
    	
    }
    
    //Function 35
    public void unjoinCommunity(Long userId , Long communityId) {
    	
    	
    }
    
    

	
}
