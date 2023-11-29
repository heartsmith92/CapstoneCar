package com.educlaas.xyzcar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.CommunityMember;
import com.educlaas.xyzcar.entity.User;

public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Long> {
	Optional<CommunityMember> findById(Long communityID);
	Community save(Community community);
	
	
}