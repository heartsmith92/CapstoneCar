package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	Community save(Community like);
}