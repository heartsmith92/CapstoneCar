package com.educlaas.xyzcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.xyzcar.entity.Share;

public interface ShareRepository extends JpaRepository<Share, Long> {
    // You can add custom query methods here if needed
	
	@Query(value = "SELECT COUNT(s.shareID) FROM Share s INNER JOIN Post p ON s.fk_postid = p.postID WHERE p.postID = :postId AND s.status = :status", nativeQuery = true)
	long countSharesByPostIdAndStatus(@Param("postId") Long postId, @Param("status") Integer status);

}