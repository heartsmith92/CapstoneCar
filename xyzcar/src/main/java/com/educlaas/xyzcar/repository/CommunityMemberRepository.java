package com.educlaas.xyzcar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.CommunityMember;

public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Long> {
	Optional<CommunityMember> findById(Long communityID);
	
}