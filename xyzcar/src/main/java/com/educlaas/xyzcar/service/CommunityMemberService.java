package com.educlaas.xyzcar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.xyzcar.entity.CommunityMember;
import com.educlaas.xyzcar.repository.CommunityMemberRepository;

@Service
public class CommunityMemberService {

    @Autowired
    private CommunityMemberRepository communityMemberRepository;

    public List<CommunityMember> getAllCommunityMembers() {
        return communityMemberRepository.findAll();
    }

    public Optional<CommunityMember> getCommunityMemberById(Long id) {
        return communityMemberRepository.findById(id);
    }

    public CommunityMember createCommunityMember(CommunityMember communityMember) {
        return communityMemberRepository.save(communityMember);
    }

    public CommunityMember updateCommunityMember(CommunityMember communityMember) {
        return communityMemberRepository.save(communityMember);
    }

    public void deleteCommunityMember(Long id) {
        communityMemberRepository.deleteById(id);
    }
}
