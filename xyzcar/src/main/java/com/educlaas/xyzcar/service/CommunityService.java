package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.repository.CommunityRepository;

@Service
public class CommunityService {
	
	@Autowired
	private  CommunityRepository communityRepository;


    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
      
    }

    public Optional<Community> getCommunityById(Long id) {
        return communityRepository.findById(id);
    }

    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    public Community updateCommunity(Community community) {
        return communityRepository.save(community);
    }

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }

	
	
}
