package com.educlaas.xyzcar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Community;
import com.educlaas.xyzcar.entity.CommunityMember;
import com.educlaas.xyzcar.entity.LikeEntity;
import com.educlaas.xyzcar.entity.Post;
import com.educlaas.xyzcar.entity.User;

public interface CommunityRepository extends JpaRepository<Community, Long> {
	Community save(Community community);
	Optional<Community> findById(Long communityID);
	CommunityMember save(CommunityMember communitymember);
	
	@Query("SELECT le FROM Community le")
	List<Community> findAllCommunity();
	
	@Query("SELECT le FROM Community le WHERE le.status = :status")
	List<Community> filterCommunitiesByStatus(@Param("status") Integer status);
	
	@Modifying
    @Query("UPDATE Community cm SET cm.status = 0 WHERE cm.user = :user AND cm.communityID = :communityID")
    void updateCommunityStatusToZero(@Param("user") User user, @Param("communityID") Long long1);

}