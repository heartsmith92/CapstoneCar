package com.educlaas.xyzcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	Community save(Community like);
	
	@Query("SELECT le FROM Community le")
	List<Community> findAllCommunity();
	
	@Query("SELECT le FROM Community le WHERE le.status = :status")
	List<Community> filterCommunitiesByStatus(@Param("status") Integer status);

}