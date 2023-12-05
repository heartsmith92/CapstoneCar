package com.educlaas.xyzcar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.CommunityMember;

import com.educlaas.xyzcar.entity.User;
import com.educlaas.xyzcar.repository.CommunityMemberRepository;
import com.educlaas.xyzcar.repository.CommunityRepository;

@Service
public class CommunityMemberService {

    @Autowired
    private CommunityMemberRepository communityMemberRepository;
   
    
    @Autowired
    private CommunityRepository communityRepository;

    public List<CommunityMember> getAllCommunityMembers() {
        return communityMemberRepository.findAll();
    }

    public Optional<CommunityMember> getCommunityMemberById(Long id) {
        return communityMemberRepository.findById(id);
    }

    
  //Function 7 Join Community as member
    public CommunityMember createCommunityMember(Integer userId, Long communityID) {
        Optional<Community> communityOptional = communityRepository.findById(communityID);
        Community community = communityOptional.orElseThrow(() -> new RuntimeException("Community not found"));

        User existingUser = community.getUser();

        if (existingUser == null) {
            throw new RuntimeException("User associated with the community not found");
        }

        CommunityMember communityMember = new CommunityMember();
        communityMember.setCreatedDate(new Date());
        communityMember.setStatus(1);
        communityMember.setUser(existingUser);
        communityMember.setCommunity(community);

        CommunityMember createMember = communityMemberRepository.save(communityMember);

        return createMember;
    }
    

    public CommunityMember updateCommunityMember(CommunityMember communityMember) {
        return communityMemberRepository.save(communityMember);
    }

    public void deleteCommunityMember(Long id) {
        communityMemberRepository.deleteById(id);
    }
    
  //Function 35
    public CommunityMember unjoinCommunityMember(Integer userId, Long communityID) {
        Optional<Community> communityOptional = communityRepository.findById(communityID);
        Community community = communityOptional.orElseThrow(() -> new RuntimeException("Community not found"));

        User existingUser = community.getUser();

        if (existingUser == null) {
            throw new RuntimeException("User associated with the community not found");
        }
        
        // deafult checking
        long statusOne = 1;

        // Find the existing membership
        CommunityMember existingMembership = communityMemberRepository.findByUserAndCommunityAndStatus(existingUser, community, statusOne);

        if (existingMembership != null) {
            // Update the status of the existing membership to 0
            existingMembership.setStatus(0);
            existingMembership.setCreatedDate(new Date()); // Update created date if needed
            // You might want to set other fields if necessary

            // Save the updated membership
            CommunityMember unjoinMember = communityMemberRepository.save(existingMembership);

            return unjoinMember;
        } else {
            throw new RuntimeException("User is not a member of this community");
        }
    
}
}
